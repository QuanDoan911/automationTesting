package browser.chrome;

import driver.manage.LocalDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalChromeDriver extends LocalDriverManager {


    public void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getArguments());
        this.driver = new ChromeDriver(options);
    }
}
