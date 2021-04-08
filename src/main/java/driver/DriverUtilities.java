package driver;

import driver.manage.DriverManagerFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertiesHelper;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DriverUtilities {


    private static final Logger logger = Logger.getLogger(DriverUtilities.class);

    public static WebDriver driver() {
        return DriverManagerFactory.getDriver();
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

    public static void waitForAjax(int timeout) {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        try {
            WebDriverWait wait = new WebDriverWait(driver(), timeout);
            wait.until(driver -> (Boolean) executor.executeScript("return jQuery.active === 0"));
            wait.until(driver -> (Boolean) executor.executeScript("return document.readyState === 'complete';"));
        } catch (Exception e) {
            logger.error("waitForAjax: An error occurred when waitForAjax: " + e.getMessage());
        }
    }

    public static void waitForJQuery(int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver(), timeout);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                boolean activeJQuery = ((JavascriptExecutor) driver).executeScript("if (typeof jQuery != 'undefined') { return jQuery.active == 0; } else {  return true; }").equals(true);
                return readyState && activeJQuery;
            }
        });
    }

    public static void waitForAlert(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static Alert switchToAlert() {
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
    }

    public static void navigateToTestSite(String url){
        driver().navigate().to(url);
        maximizeBrowser();
        waitForAjax(PropertiesHelper.getIntValue("Short_Timeout"));
    }
}
