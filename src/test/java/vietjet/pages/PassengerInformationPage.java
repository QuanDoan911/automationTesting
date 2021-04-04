package vietjet.pages;

import common.Constants;
import driver.DriverUtilities;
import element.common.imp.*;
import org.openqa.selenium.WebElement;
import vietjet.customcontrols.DatePicker;

import java.util.List;

public class PassengerInformationPage extends BasePage {

    private PassengerInformationPage(){
        DriverUtilities.waitForAjax(Constants.LONG_TIMEOUT);
    }

    private static class SingletonHelper{
        private static final PassengerInformationPage INSTANCE = new PassengerInformationPage();
    }

    public static PassengerInformationPage getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public Label lblPageName = new Label("//h1[text()='Passenger Information']");

    public boolean isPassengerInformationPageDisplayed() {
        return isPageDisplayed(lblPageName);
    }
}
