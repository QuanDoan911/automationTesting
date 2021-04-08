package vietjet.pages;

import common.Constants;
import driver.DriverUtilities;
import element.common.imp.Button;
import element.common.imp.CheckBox;
import element.common.imp.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.StringHelper;

import java.util.List;

import static driver.DriverUtilities.driver;

public class SelectTravelOptionsPage extends BasePage {

    public SelectTravelOptionsPage() {
        DriverUtilities.waitForJQuery(Constants.MEDIUM_TIMEOUT);
    }

    public Button btnContinue = new Button("//a[text()='Continue']");
    public CheckBox chkFirstDepartPrice = new CheckBox("//td[contains(@id,'gridTravelOptDep-1-') and @data-familyid='Eco']//input[@id='gridTravelOptDep']");
    public CheckBox chkFirstReturnPrice = new CheckBox("//td[contains(@id,'gridTravelOptRet-1-') and @data-familyid='Eco']//input[@id='gridTravelOptRet']");
    public Label lblFirstDepartPrice = new Label("//td[contains(@id,'gridTravelOptDep-1-') and @data-familyid='Eco']");
    public Label lblFirstReturnPrice = new Label("//td[contains(@id,'gridTravelOptRet-1-') and @data-familyid='Eco']");
    public Label lblPageName = new Label("//h1[text()='Select Travel Options']");

    public boolean isSelectTravelOptionsPageDisplayed() {
        return isPageDisplayed(lblPageName);
    }

    public int selectCheapestDepartTicket() {
        int price = Integer.parseInt(StringHelper.extractNumber(lblFirstDepartPrice.getText()));
        chkFirstDepartPrice.check();
        List<WebElement> grid = driver().findElements(By.xpath("//div[@id='toDepDiv']//table[@class='FaresGrid']//td"));
        for (WebElement cell : grid) {
            if (Integer.parseInt(cell.getText().replaceAll("[^0-9]", "")) < price) {
                price = Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""));
                cell.findElement(By.xpath(".//input[@id='gridTravelOptDep']")).click();
            }
        }
        return price;
    }

    public int selectCheapestReturnTicket() {
        int price = Integer.parseInt(lblFirstReturnPrice.getText().replaceAll("[^0-9]", ""));
        chkFirstReturnPrice.check();
        List<WebElement> grid = driver().findElements(By.xpath("//div[@id='toRetDiv']//table[@class='FaresGrid']//td"));
        for (WebElement cell : grid) {
            if (Integer.parseInt(cell.getText().replaceAll("[^0-9]", "")) < price) {
                price = Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""));
                cell.findElement(By.xpath(".//input[@id='gridTravelOptRet']")).click();
            }
        }
        return price;
    }

    public void clickContinue() {
        btnContinue.waitForClickable(Constants.SHORT_TIMEOUT);
        btnContinue.click();
    }

}
