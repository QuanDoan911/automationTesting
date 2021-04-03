package vietjet.pages;

import common.Constants;
import driver.DriverUtilities;
import element.common.imp.Button;
import element.common.imp.CheckBox;
import element.common.imp.Combobox;
import element.common.imp.TextBox;
import vietjet.customcontrols.GroupComboBox;

public class HomePage extends BasePage {

    private HomePage(){
        DriverUtilities.waitForAjax(Constants.LONG_TIMEOUT);
    }

    private static class SingletonHelper{
        private static final HomePage INSTANCE = new HomePage();
    }

    public static HomePage getInstance(){
        return SingletonHelper.INSTANCE;
    }

    CheckBox chkReturn = new CheckBox("id=ctl00_UcRightV31_RbRoundTrip");
    CheckBox chkOneWay = new CheckBox("id=ctl00_UcRightV31_RbOneWay");
    CheckBox chkCheckInFare = new CheckBox("id=ctl00_UcRightV31_ChkInfare");
    Combobox cbxAdults = new Combobox("id=ctl00_UcRightV31_CbbAdults_TextBox");
    Button btnSearchFlights = new Button("id=ctl00_UcRightV31_BtSearch");
    GroupComboBox cbxOrigin = new GroupComboBox("id=selectOrigin");
    GroupComboBox cbxDestination = new GroupComboBox("id=selectDestination");
    TextBox txtAdults = new TextBox("id=ctl00_UcRightV31_CbbAdults_OptionList");
    TextBox txtDepartDate = new TextBox("id=ctl00_UcRightV31_TxtDepartDate");
    TextBox txtReturnDate = new TextBox("id=ctl00_UcRightV31_TxtReturnDate");
    TextBox txtCurrency = new TextBox("id=ctl00_UcRightV31_CbbCurrency_TextBox");

    void clickSearch(){
        btnSearchFlights.waitForClickable(Constants.SHORT_TIMEOUT);
        btnSearchFlights.click();
    }

    public void searchFlights(boolean isReturn, String groupOrigin, String origin, String groupDestination, String destination, String departDate, String returnDate, String currency, boolean isFindLowestPrice, int adultsNum){
        selectTicketType(isReturn);
        selectOriginDestination(groupOrigin, origin, groupDestination, destination);
        selectDate(departDate, returnDate);

        //TODO: enable this code when currency is enabled
        //selectCurrency(currency);

        selectFindLowestPrice(isFindLowestPrice);
        selectAdultTicketNumber(adultsNum);

        clickSearch();
    }

    void selectAdultTicketNumber(int adultsNum){
        if(adultsNum>0&&adultsNum<=9)
            txtAdults.enter(String.valueOf(adultsNum));
        else
            System.out.println("Number of adults is out of range");
    }

    void selectCurrency(String currency){
        if(!currency.isEmpty()&&!currency.equals(null)) {
            txtCurrency.waitForClickable(Constants.SHORT_TIMEOUT);
            txtCurrency.enter(currency);
        }
    }

    void selectDate(String departDate, String returnDate){
        txtDepartDate.waitForClickable(Constants.SHORT_TIMEOUT);
        txtDepartDate.enter(departDate);
        txtReturnDate.waitForClickable(Constants.SHORT_TIMEOUT);
        txtReturnDate.enter(returnDate);
    }

    void selectFindLowestPrice(boolean isFindLowestPrice){
        if(isFindLowestPrice) {
            chkCheckInFare.waitForClickable(Constants.SHORT_TIMEOUT);
            chkCheckInFare.check();
        }else {
            chkCheckInFare.waitForClickable(Constants.SHORT_TIMEOUT);
            chkCheckInFare.uncheck();
        }
    }

    void selectOriginDestination(String groupOrigin, String origin, String groupDestination, String destination){
        cbxOrigin.waitForClickable(Constants.SHORT_TIMEOUT);
        cbxOrigin.select(groupOrigin, origin);

        cbxDestination.waitForClickable(Constants.SHORT_TIMEOUT);
        cbxDestination.select(groupDestination, destination);
    }

    void selectTicketType(boolean isReturn){
        if(isReturn) {
            chkReturn.waitForClickable(Constants.SHORT_TIMEOUT);
            chkReturn.check();
        }else {
            chkOneWay.waitForClickable(Constants.SHORT_TIMEOUT);
            chkOneWay.check();
        }
    }
}
