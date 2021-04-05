package vietjet.pages;

import org.openqa.selenium.WebElement;
import vietjet.element.Table;

import java.util.ArrayList;
import java.util.List;

public class SelectFarePage {

    Table tblDeparture = new Table("id=ctrValueViewerDepGrid");
    Table tblReturn = new Table("id=ctrValueViewerRetGrid");


    public List<String> getPriceNextThreeMonth(String fromMonth) {
        List<String> cellValues = new ArrayList<>();
        List<WebElement> cells;

        //clickNext
        cells = tblDeparture.getCells();
        for (WebElement cell : cells) {
            cellValues.add(cell.getText());
        }
        return cellValues;
    }
}
