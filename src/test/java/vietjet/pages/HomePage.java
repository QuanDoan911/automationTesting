package vietjet.pages;

import driver.DriverUtilities;
import element.common.imp.*;
import org.openqa.selenium.WebElement;
import vietjet.customcontrols.DatePicker;

import java.util.List;

import static common.Constants.MEDIUM_TIMEOUT;
import static common.Constants.SHORT_TIMEOUT;

public class HomePage extends BasePage {

    public HomePage() {
        DriverUtilities.waitForJQuery(MEDIUM_TIMEOUT);
    }

    Button btnAdults = new Button("id=ctl00_UcRightV31_CbbAdults_Button");
    Button btnSearchFlights = new Button("id=ctl00_UcRightV31_BtSearch");
    CheckBox chkReturn = new CheckBox("id=ctl00_UcRightV31_RbRoundTrip");
    CheckBox chkOneWay = new CheckBox("id=ctl00_UcRightV31_RbOneWay");
    CheckBox chkCheckInFare = new CheckBox("id=ctl00_UcRightV31_ChkInfare");
    Combobox cbxOrigin = new Combobox("id=selectOrigin");
    Combobox cbxDestination = new Combobox("id=selectDestination");
    Combobox cbxMonthPicker = new Combobox("//div[@id='ui-datepicker-div']//select");
    DatePicker tblDayPicker = new DatePicker("//div[@id='ui-datepicker-div']//tbody");
    Label lblAdultNumbers = new Label("//ul[@id='ctl00_UcRightV31_CbbAdults_OptionList']/li");
    TextBox txtAdults = new TextBox("id=ctl00_UcRightV31_CbbAdults_TextBox");
    TextBox txtDepartDate = new TextBox("id=ctl00_UcRightV31_TxtDepartDate");
    TextBox txtReturnDate = new TextBox("id=ctl00_UcRightV31_TxtReturnDate");
    TextBox txtCurrency = new TextBox("id=ctl00_UcRightV31_CbbCurrency_TextBox");

    void clickSearchButton() {
        btnSearchFlights.waitForClickable(SHORT_TIMEOUT);
        btnSearchFlights.click();
    }

    public void searchFlights(boolean isReturn, String origin, String destination, String departDate, String returnDate, String currency, boolean isFindLowestPrice, int adultsNum) {
        selectTicketType(isReturn);
        selectOriginDestination(origin, destination);
        selectDepartReturn(departDate, returnDate);

        //TODO: enable this code when currency is enabled
        //selectCurrency(currency);

        selectFindLowestPrice(isFindLowestPrice);
        selectAdultTicketNumber(adultsNum);

        clickSearchButton();
    }

    void selectAdultTicketNumber(int adultsNum) {
        if (adultsNum > 0 && adultsNum <= 9) {
            btnAdults.click();
            List<WebElement> options = lblAdultNumbers.findElements();
            for (WebElement option : options) {
                if (option.getText().equals(String.valueOf(adultsNum))) {
                    option.click(); // click the desired option
                    break;
                }
            }
        } else
            System.out.println("Number of adults is out of range");
    }

    void selectCurrency(String currency) {
        if (!currency.isEmpty() && !currency.equals(null)) {
            txtCurrency.waitForClickable(SHORT_TIMEOUT);
            txtCurrency.enter(currency);
        }
    }

    void selectDate(String date) {
        String[] parts = date.split("/");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        cbxMonthPicker.selectByText(month);
        tblDayPicker.waitForClickable(SHORT_TIMEOUT);
        tblDayPicker.selectDay(day);
    }

    void selectDepartReturn(String departDate, String returnDate) {
        txtDepartDate.waitForClickable(SHORT_TIMEOUT);
        txtDepartDate.click();
        selectDate(departDate);

        txtReturnDate.waitForClickable(SHORT_TIMEOUT);
        txtReturnDate.click();
        selectDate(returnDate);
    }

    void selectFindLowestPrice(boolean isFindLowestPrice) {
        if (isFindLowestPrice) {
            chkCheckInFare.waitForClickable(SHORT_TIMEOUT);
            chkCheckInFare.check();
        } else {
            chkCheckInFare.waitForClickable(SHORT_TIMEOUT);
            chkCheckInFare.uncheck();
        }
    }

    void selectOriginDestination(String origin, String destination) {
        cbxOrigin.waitForClickable(SHORT_TIMEOUT);
        cbxOrigin.selectByValue(origin);

        cbxDestination.waitForClickable(SHORT_TIMEOUT);
        cbxDestination.selectByValue(destination);
    }

    void selectTicketType(boolean isReturn) {
        if (isReturn) {
            chkReturn.waitForClickable(SHORT_TIMEOUT);
            chkReturn.check();
        } else {
            chkOneWay.waitForClickable(SHORT_TIMEOUT);
            chkOneWay.check();
        }
    }
}
