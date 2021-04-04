package vietjet.pages;

import element.common.imp.Label;
import utilities.DateTimeHelper;

import java.text.ParseException;

class BasePage {
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

    public boolean isPageDisplayed(Label pageName) {
        return pageName.isDisplayed();
    }

    public boolean isAdultNumberDisplaysCorrect(int expectedNumber) {
        return Integer.parseInt(lblAdultNumber.getText().replaceAll("[^0-9]", "")) == expectedNumber;
    }

    public boolean isCurrencyDisplaysCorrect(String currency){
        return lblCurrency.getText().contains(currency);
    }

    public boolean isDepartDateDisplaysCorrect(String expectedDate) throws ParseException {
        expectedDate = DateTimeHelper.convertDateFormat(expectedDate,"d/MMM/yyyy","dd/MM/yyyy");
        String actualDate = lblDepartDate.getText().split(" ")[0];
        return actualDate.equals(expectedDate);
    }

    public boolean isDepartFareDisplaysCorrect(int expectedFare){
        int actualFare = Integer.parseInt(lblDepartFare.getText().replaceAll("[^0-9]", ""));
        return actualFare == expectedFare;
    }

    public boolean isDepartFromDisplaysCorrect(String expectedFrom){
        return lblDepartFrom.getText().contains(expectedFrom);
    }

    public boolean isDepartToDisplaysCorrect(String expectedTo){
        return lblDepartTo.getText().contains(expectedTo);
    }

    public boolean isReturnDateDisplaysCorrect(String expectedDate) throws ParseException {
        expectedDate = DateTimeHelper.convertDateFormat(expectedDate,"d/MMM/yyyy","dd/MM/yyyy");
        String actualDate = lblReturnDate.getText().split(" ")[0];
        return actualDate.equals(expectedDate);
    }

    public boolean isReturnFareDisplaysCorrect(int expectedFare){
        int actualFare = Integer.parseInt(lblReturnFare.getText().replaceAll("[^0-9]", ""));
        return actualFare == expectedFare;
    }

    public boolean isReturnFromDisplaysCorrect(String expectedFrom){
        return lblReturnFrom.getText().contains(expectedFrom);
    }

    public boolean isReturnToDisplaysCorrect(String expectedTo){
        return lblReturnTo.getText().contains(expectedTo);
    }
}
