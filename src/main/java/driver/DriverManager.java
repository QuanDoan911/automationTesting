package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public abstract class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();

    public abstract void createWebDriver();

    public static WebDriver getWebDriver() {
        return DRIVERS.get();
    }

    public void setWebDriver() {
        if (null == driver) {
            createWebDriver();
        }
        DRIVERS.set(driver);
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    protected WebDriver driver;
    private String remoteUrl;
    private List<String> arguments;
    private DesiredCapabilities capabilities;
}

