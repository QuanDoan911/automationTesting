package element.common.imp;

import element.base.imp.Editable;
import element.common.ICombobox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Combobox extends Editable implements ICombobox {

    public Combobox(String locator) {
        super(locator);
    }

    public void select(String text) {
        Select select = new Select(findElement());
        select.selectByVisibleText(text);
    }

    public void select(int index) {
        Select select = new Select(findElement());
        select.selectByIndex(index);
    }

    public List<String> getOptions() {
        List<String> ops = new ArrayList<>();
        Select select = new Select(findElement());
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            ops.add(option.getText());
        }
        return ops;
    }

    public String getSelected() {
        Select select = new Select(findElement());
        return select.getFirstSelectedOption().getText();
    }
}