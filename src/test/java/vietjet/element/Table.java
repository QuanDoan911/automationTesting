package vietjet.element;

import element.base.imp.BaseControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends BaseControl {

    public Table(String locator) {
        super(locator);
    }

    private String rows = "./tbody/tr[not(th)]";
    private String columns = "./tbody/tr[@style]/th";
    private String rowByIndex = rows + "[%s]";
    private String cellOfRowByColumnIndex = "./td[%s]";


    public int getNumberOfRows() {
        return this.getChildElements(rows).size();
    }

    public int getNumberOfColumns() {
        return this.getChildElements(columns).size();
    }

    public WebElement getCell(int colIdx, int rowIdx) {
        WebElement row = this.getChildElement(String.format(this.rowByIndex, rowIdx));
        return row.findElement(By.xpath(String.format(cellOfRowByColumnIndex, colIdx)));
    }

    public List<WebElement> getCells() {
        int totalRows = getNumberOfRows();
        int totalColumn = getNumberOfColumns();
        List<WebElement> list = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumn; j++) {
                list.add(getCell(i, j));
            }
        }
        return list;
    }
}
