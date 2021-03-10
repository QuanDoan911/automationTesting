package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public void closeBrowser(WebDriver driver) {
        driver.quit();
    }

    public void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void implicitlyWait(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void waitForTitle(WebDriver driver, String title) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains(title));
    }
}
