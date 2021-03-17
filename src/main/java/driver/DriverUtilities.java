package driver;

import globalvariables.GlobalVariables;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverUtilities {

    public static WebDriver driver() {
        return DriverManager.getWebDriver();
    }

    public static void closeBrowser() {
        driver().quit();
    }

    public static void maximizeBrowser() {
        driver().manage().window().maximize();
    }

    public static void implicitlyWait(int timeout) {
        driver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static String getTitle() {
        return driver().getTitle();
    }

    public static void waitForTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitForPageLoad(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        try {
            wait.until(driver -> (boolean) ((JavascriptExecutor) driver()).executeScript("return jQuery.active == 0"));
            wait.until(driver -> (boolean) ((JavascriptExecutor) driver()).executeScript("return document.readyState")
                    .equals("complete"));
        } catch (Exception e) {
        }
    }

    public static void waitForAlert(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static Alert switchToAlert() {
        waitForAlert(GlobalVariables.SHORT_TIMEOUT);
        return driver().switchTo().alert();
    }

    public static void acceptAlert() {
        try {
            switchToAlert().accept();
        } catch (Exception e) {
            switchToAlert().accept();
        }
    }

    public static void dismissAlert() {
        switchToAlert().dismiss();
    }

    public static String getTextAlert() {
        String alertText = switchToAlert().getText();
        dismissAlert();
        return alertText;
    }

    public static void sendKeyAlert(String value) {
        switchToAlert().sendKeys(value);
    }

    public void refreshPage() {
        driver().navigate().refresh();
        waitForPageLoad(GlobalVariables.MEDIUM_TIMEOUT);
    }
}
