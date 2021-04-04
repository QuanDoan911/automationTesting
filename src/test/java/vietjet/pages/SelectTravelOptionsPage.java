package vietjet.pages;

import common.Constants;
import driver.DriverUtilities;
import element.common.imp.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DateTimeHelper;

import java.text.ParseException;
import java.util.List;

import static driver.DriverUtilities.driver;

public class SelectTravelOptionsPage extends BasePage {

    private SelectTravelOptionsPage(){
        DriverUtilities.waitForAjax(Constants.LONG_TIMEOUT);
    }

    private static class SingletonHelper{
        private static final SelectTravelOptionsPage INSTANCE = new SelectTravelOptionsPage();
    }

    public static SelectTravelOptionsPage getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public Button btnContinue = new Button("//a[text()='Continue']");
    public CheckBox chkFirstDepartPrice = new CheckBox("//td[@id='gridTravelOptDep-1-E_Eco-O']//input[@id='gridTravelOptDep']");
    public CheckBox chkFirstReturnPrice = new CheckBox("//td[@id='gridTravelOptRet-1-E_Eco-O']//input[@id='gridTravelOptRet']");
    public Label lblFirstDepartPrice = new Label("id=gridTravelOptDep-1-E_Eco-O");
    public Label lblFirstReturnPrice = new Label("id=gridTravelOptRet-1-E_Eco-O");
    public Label lblPageName = new Label("//h1[text()='Select Travel Options']");

    public boolean isSelectTravelOptionsPageDisplayed() {
        return isPageDisplayed(lblPageName);
    }

    public int selectCheapestDepartTicket(){
        int price = Integer.parseInt(lblFirstDepartPrice.getText().replaceAll("[^0-9]", ""));
        chkFirstDepartPrice.check();
        List<WebElement> grid = driver().findElements(By.xpath("//div[@id='toDepDiv']//table[@class='FaresGrid']//td"));
        for (WebElement cell: grid) {
            if (Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""))<price) {
                price = Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""));
                cell.findElement(By.xpath(".//input[@id='gridTravelOptDep']")).click();
            }
        }
        return price;
    }

    public int selectCheapestReturnTicket(){
        int price = Integer.parseInt(lblFirstReturnPrice.getText().replaceAll("[^0-9]", ""));
        chkFirstReturnPrice.check();
        List<WebElement> grid = driver().findElements(By.xpath("//div[@id='toRetDiv']//table[@class='FaresGrid']//td"));
        for (WebElement cell: grid) {
            if (Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""))<price) {
                price = Integer.parseInt(cell.getText().replaceAll("[^0-9]", ""));
                cell.findElement(By.xpath(".//input[@id='gridTravelOptRet']")).click();
            }
        }
        return price;
    }

    public void clickContinue(){
        btnContinue.waitForClickable(Constants.SHORT_TIMEOUT);
        btnContinue.click();
    }

}
