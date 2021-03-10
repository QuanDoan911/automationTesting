package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public abstract class DriverManager {

    public WebDriver driver;
    public abstract void createWebDriver();
    public void quitWebDriver() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getWebDriver() {
        if (driver == null)
            createWebDriver();
        return driver;
    }
}
