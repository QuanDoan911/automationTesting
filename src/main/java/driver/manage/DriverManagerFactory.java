package driver.manage;

import driver.DriverProperty;
import driver.manage.DriverManager;
import org.apache.hc.core5.util.ReflectionUtils;
import org.openqa.selenium.WebDriver;
import utilities.JsonHelper;

public class DriverManagerFactory {

    protected static final ThreadLocal<DriverManager> webDrivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDrivers.get().getWebDriver();
    }

    public static void setWebDriver(DriverManager driverManager) {
        if (webDrivers.get() == null) {
            driverManager.createWebDriver();
        }
        webDrivers.set(driverManager);
    }

    public static void createWebDriver(DriverProperty property) throws IllegalAccessException {
        DriverManager driverManager = initWebDriver(property);
        setWebDriver(driverManager);
    }

    public static DriverManager initWebDriver(DriverProperty property) throws IllegalAccessException {
        DriverManager driverManager = null;
        String driver = property.getDriver();
        String mode = property.getMode();
        String className = mode + driver + "Driver";

        try {
            Class<?> driverClass = Class.forName("browser." + driver.toLowerCase() + "." + className);
            try {
                driverManager = (DriverManager) driverClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        driverManager.setRemoteUrl(property.getRemoteUrl());
        driverManager.setArguments(property.getArguments());
        driverManager.setCapabilities(property.getCapabilities());

        return driverManager;
    }
}
