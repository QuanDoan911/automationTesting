package vietjet.customcontrols;

import element.base.imp.Clickable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePicker extends Clickable {
    public DatePicker(String locator) {
        super(locator);
    }

    public void selectDay(String day) {
        List<WebElement> columns = findElement().findElements(By.tagName("td"));
        for (WebElement cell : columns) {
            if (cell.getText().equals(day)) {
                cell.click();
                break;
            }
        }
    }
}
