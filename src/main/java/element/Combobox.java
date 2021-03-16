package element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Combobox extends BaseElement {

    public Combobox(String locator) {
        super(locator);
    }

    public Select select() {
        return new Select(findElement());
    }

    public void selectByVisibleText(String text) {
        select().selectByVisibleText(text);
    }

    public void selectByIndex(int index) {
        select().selectByIndex(index);
    }

    public void selectByValue(String value) {
        select().selectByValue(value);
    }

    public List<WebElement> getOptions() {
        return select().getOptions();
    }
}