package element;

import globalvariables.GlobalVariables;
import driver.DriverUtilities;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.apache.log4j.Logger;

public class BaseElement {

    private Logger logger = Logger.getLogger(BaseElement.class);
    private final String locator;

    public BaseElement(String locator) {
        this.locator = locator;
    }

    private By getLocator() {
        String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
        String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
        switch (type) {
            case "css":
                return By.cssSelector(body);
            case "id":
                return By.id(body);
            case "class":
                return By.className(body);
            case "xpath":
                return By.xpath(body);
            case "name":
                return By.name(body);
            default:
                return By.xpath(locator);
        }
    }

    private WebDriver driver() {
        return DriverUtilities.driver();
    }

    protected WebElement findElement() {
        return driver().findElement(getLocator());
    }

    public List<WebElement> findElements() {
        return driver().findElements(getLocator());
    }

    public void submit() {
        findElement().submit();
    }

    public void click() {
        findElement().click();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NotFoundException e) {
            logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), e.getMessage()));
            return false;
        }
    }

    public void moveMouse() {
        Actions action = new Actions(driver());
        action.moveToElement(findElement()).perform();
    }

    public int getHeight() {
        return findElement().getSize().getHeight();
    }

    public int getWidth() {
        return findElement().getSize().getWidth();
    }

    public int getTop() {
        return findElement().getLocation().getY();
    }

    public int getLeft() {
        return findElement().getLocation().getX();
    }

    public String getAttribute(String name) {
        return findElement().getAttribute(name);
    }

    public void waitForClickable(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver(), timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(findElement()));
    }

    public void waitForVisible(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver(), timeOut);
        wait.until(ExpectedConditions.visibilityOf(findElement()));
    }

    public void waitForInVisible(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver(), timeOut);
        wait.until(ExpectedConditions.invisibilityOf(findElement()));
    }

    public void waitForAttributeContains(int timeOut, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver(), timeOut);
        wait.until(ExpectedConditions.attributeContains(findElement(), attribute, value));
    }

    public void scrollToElement() {
        waitForVisible(GlobalVariables.SHORT_TIMEOUT);
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView();", findElement());
    }
}