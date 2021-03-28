package element.base.imp;

import element.base.IClickable;
import org.openqa.selenium.interactions.Actions;

import static driver.manage.DriverManagerFactory.getDriver;

public class Clickable extends BaseControl implements IClickable {

    public Clickable(String locator) {
        super(locator);
    }

    @Override
    public void click() {
        findElement().click();
    }

    public void click(int x, int y) {
        new Actions(getDriver()).moveToElement(findElement(), x, y).click().build().perform();
    }

    public void doubleClick() {
        new Actions(getDriver()).doubleClick(findElement()).build().perform();
    }
}
