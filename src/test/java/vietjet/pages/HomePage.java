package vietjet.pages;

import element.common.ICheckBox;
import element.common.ICombobox;
import element.common.imp.CheckBox;
import element.common.imp.Combobox;
import element.common.imp.TextBox;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    CheckBox chkReturn = new CheckBox("id=ctl00_UcRightV31_RbRoundTrip");
    CheckBox chkCheckInFare = new CheckBox("id=ctl00_UcRightV31_ChkInfare");
    Combobox cbxAdults = new Combobox("id=ctl00_UcRightV31_CbbAdults_TextBox");
    Combobox cbxOrigin = new Combobox("id=selectOrigin");
    Combobox cbxDestination = new Combobox("id=selectDestination");
    TextBox txtDepartDate = new TextBox("id=ctl00_UcRightV31_TxtDepartDate");
    TextBox txtReturnDate = new TextBox("id=ctl00_UcRightV31_TxtReturnDate");

}
