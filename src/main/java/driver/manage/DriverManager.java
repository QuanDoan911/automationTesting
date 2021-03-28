package driver.manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.JsonHelper;

import java.util.List;

public abstract class DriverManager {

    public abstract void createWebDriver();

    public WebDriver getWebDriver() {
        return driver;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public List<String> getArguments() {
        return JsonHelper.convertJsonToList(arguments);
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public DesiredCapabilities getCapabilities() {
        return JsonHelper.convertJsonToDesiredCapabilities(this.capabilities);
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    protected WebDriver driver;
    protected String remoteUrl;
    private String arguments;
    private String capabilities;
}

