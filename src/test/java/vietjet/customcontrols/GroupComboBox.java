package vietjet.customcontrols;

import element.common.ICombobox;
import element.common.imp.Combobox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class GroupComboBox extends Combobox implements ICombobox {

    public GroupComboBox(String locator) {
        super(locator);
    }

    /***
     * Purpose: select an option of the combo box by text
     * @param groupOption group contains selected option
     * @param text text of selected option
     */
    public void select(String groupOption, String text) {
        Select select = new Select(findElement().findElement(By.xpath(groupOption)));
        select.selectByVisibleText(text);
    }

    /***
     * Purpose: select an option of the combo box by index
     * @param groupOption group contains selected option
     * @param index index of selected option
     */
    public void select(String groupOption, int index) {
        Select select = new Select(findElement().findElement(By.xpath(groupOption)));
        select.selectByIndex(index);
    }

    /***
     * Purpose: get a list of option under the group
     * @param groupOption group contains selected option
     * @return option list
     */
    public List<String> getOptionsUnderGroup(String groupOption) {
        List<String> ops = new ArrayList<>();
        Select select = new Select(findElement().findElement(By.xpath(groupOption)));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            ops.add(option.getText());
        }
        return ops;
    }

    /***
     * Purpose: get text of the selected option under the group
     * @param groupOption
     * @return selected text
     */
    public String getSelected(String groupOption) {
        Select select = new Select(findElement().findElement(By.xpath(groupOption)));
        return select.getFirstSelectedOption().getText();
    }

}
