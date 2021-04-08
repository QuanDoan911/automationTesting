package vietjet.pages;

import driver.DriverUtilities;
import element.common.imp.Label;

import static common.Constants.MEDIUM_TIMEOUT;

public class PassengerInformationPage extends BasePage {

    public PassengerInformationPage() {
        DriverUtilities.waitForJQuery(MEDIUM_TIMEOUT);
    }

    public Label lblPageName = new Label("//h1[text()='Passenger Information']");

    public boolean isPassengerInformationPageDisplayed() {
        return isPageDisplayed(lblPageName);
    }
}
