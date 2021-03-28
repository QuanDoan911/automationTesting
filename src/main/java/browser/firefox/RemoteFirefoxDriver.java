package browser.firefox;

import driver.manage.RemoteDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxDriver extends RemoteDriverManager {
    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getArguments());
        options.merge(getCapabilities());
        this.driver = new RemoteWebDriver(getRemoteUrl(), options);
    }
}
