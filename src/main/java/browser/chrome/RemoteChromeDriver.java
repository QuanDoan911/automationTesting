package browser.chrome;

import driver.manage.RemoteDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeDriver extends RemoteDriverManager {

    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getArguments());
        options.merge(getCapabilities());
        this.driver = new RemoteWebDriver(getRemoteUrl(), options);
    }
}
