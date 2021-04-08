package vietjet.pages;

import element.common.imp.Label;
import utilities.StringHelper;

public class BookingSummaryPage extends BasePage {
    public Label lblAdultNumber = new Label("//table[@id='tblPaxCountsInfo']//span[contains(text(),'Adults')]/..");
    public Label lblCurrency = new Label("//div[@id='sidebar']//p");
    public Label lblDepartDate = new Label("id=Leg1Date");
    public Label lblDepartFare = new Label("id=Leg1BSFare");
    public Label lblDepartFrom = new Label("//table[@id='tblLeg1APs']//td[span[contains(text(),'From')]]");
    public Label lblDepartTo = new Label("//table[@id='tblLeg1APs']//td[span[contains(text(),'To')]]");
    public Label lblReturnDate = new Label("id=Leg2Date");
    public Label lblReturnFare = new Label("id=Leg2BSFare");
    public Label lblReturnFrom = new Label("//table[@id='tblLeg2APs']//td[span[contains(text(),'From')]]");
    public Label lblReturnTo = new Label("//table[@id='tblLeg2APs']//td[span[contains(text(),'To')]]");

    public int getAdultNumber() {
        return Integer.parseInt(StringHelper.extractNumber(lblAdultNumber.getText()));
    }

    public int getDepartFare() {
        return Integer.parseInt(StringHelper.extractNumber(lblDepartFare.getText()));
    }

    public int getReturnFare() {
        return Integer.parseInt(StringHelper.extractNumber(lblReturnFare.getText()));
    }

    public String getDepartDate() {
        return lblDepartDate.getText().split(" ")[0];
    }

    public String getReturnDate() {
        return lblReturnDate.getText().split(" ")[0];
    }

    public boolean isCurrencyDisplayedCorrectly(String currency) {
        return lblCurrency.getText().contains(currency);
    }

    public boolean isDepartFromDisplayedCorrectly(String expectedFrom) {
        return lblDepartFrom.getText().contains(expectedFrom);
    }

    public boolean isDepartToDisplayedCorrectly(String expectedTo) {
        return lblDepartTo.getText().contains(expectedTo);
    }

    public boolean isReturnFromDisplayedCorrectly(String expectedFrom) {
        return lblReturnFrom.getText().contains(expectedFrom);
    }

    public boolean isReturnToDisplayedCorrectly(String expectedTo) {
        return lblReturnTo.getText().contains(expectedTo);
    }
}
