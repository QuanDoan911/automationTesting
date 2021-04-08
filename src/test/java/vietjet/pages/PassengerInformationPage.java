package vietjet.pages;

import common.Constants;
import driver.DriverUtilities;
import element.common.imp.Label;

public class PassengerInformationPage extends BasePage {

    public PassengerInformationPage() {
        DriverUtilities.waitForJQuery(Constants.MEDIUM_TIMEOUT);
    }

    public Label lblPageName = new Label("//h1[text()='Passenger Information']");

    public boolean isPassengerInformationPageDisplayed() {
        return isPageDisplayed(lblPageName);
    }
}
