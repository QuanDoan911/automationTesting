package browser.firefox;

import java.net.MalformedURLException;
import java.net.URL;

import driver.DriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxDriver extends DriverManager {
    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getArguments());
        options.merge(getCapabilities());
        try {
            this.driver = new RemoteWebDriver(new URL(getRemoteUrl()), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
