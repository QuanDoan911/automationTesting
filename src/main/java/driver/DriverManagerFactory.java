package driver;

import utilities.JsonHelper;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverProperty property) {
        DriverManager driverManager = null;
        String driver = property.getDriver();
        String mode = property.getMode();
        String className = mode + driver + "Driver";

        try {
            Class<?> driverClass = Class.forName("com.sourcetree.browser." + driver.toLowerCase() + "." + className);
            try {
                driverManager = (DriverManager) driverClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        driverManager.setRemoteUrl(property.getRemoteUrl());
        driverManager.setArguments(JsonHelper.convertJsonToList(property.getArguments()));
        driverManager.setCapabilities(JsonHelper.convertJsonToDesiredCapabilities(property.getCapabilities()));

        return driverManager;
    }
}
