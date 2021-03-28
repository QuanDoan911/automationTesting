package browser.firefox;

import driver.manage.LocalDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalFirefoxDriver extends LocalDriverManager {
    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getArguments());
        this.driver = new FirefoxDriver(options);
    }
}
