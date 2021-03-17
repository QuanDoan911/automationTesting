package browser.firefox;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalFirefoxDriver extends DriverManager {
    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(getArguments());
        this.driver = new FirefoxDriver(options);
    }
}
