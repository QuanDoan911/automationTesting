package vietjet.testcases;

import common.Constants;
import driver.DriverUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeHelper;
import vietjet.pages.BookingSummaryPage;
import vietjet.pages.HomePage;
import vietjet.pages.PassengerInformationPage;
import vietjet.pages.SelectTravelOptionsPage;

import java.util.Hashtable;

public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        int daysPlusToDepart = Integer.parseInt(data.get("plusToDepartDate"));
        int daysPlusToReturn = Integer.parseInt(data.get("plusToReturnDate"));
        int adultNumber = Integer.parseInt(data.get("adultsNum"));
        String departDateNum = DateTimeHelper.plusDaysFromCurrent(daysPlusToDepart, Constants.DATE_FORMAT_NUMBER);
        String returnDateNum = DateTimeHelper.plusDaysFromCurrent(daysPlusToReturn, Constants.DATE_FORMAT_NUMBER);
        String departDateWithMonthChar = DateTimeHelper.plusDaysFromCurrent(daysPlusToDepart, Constants.DATE_FORMAT_CONTAINS_CHARACTERS);
        String returnDateWithMonthChar = DateTimeHelper.plusDaysFromCurrent(daysPlusToReturn, Constants.DATE_FORMAT_CONTAINS_CHARACTERS);

        System.out.println("Navigate to test site");
        DriverUtilities.navigateToTestSite(Constants.VIETJET_URL);

        System.out.println("Search flight");
        HomePage homePage = new HomePage();
        homePage.searchFlights(Boolean.parseBoolean(data.get("isReturn")), data.get("origin"), data.get("destination"), departDateWithMonthChar, returnDateWithMonthChar, data.get("currency"), Boolean.parseBoolean(data.get("isFindLowestPrice")), adultNumber);

        System.out.println("Verify that Select Travel Options page displays");
        SelectTravelOptionsPage selectTravelOptionsPage = new SelectTravelOptionsPage();
        Assert.assertTrue(selectTravelOptionsPage.isSelectTravelOptionsPageDisplayed());

        System.out.println("Verify that Information displays correctly");
        BookingSummaryPage bookingSummaryPage = new BookingSummaryPage();
        Assert.assertEquals(bookingSummaryPage.getAdultNumber(), adultNumber);
        Assert.assertEquals(bookingSummaryPage.getDepartDate(), departDateNum);
        Assert.assertEquals(bookingSummaryPage.getReturnDate(), returnDateNum);
        Assert.assertTrue(bookingSummaryPage.isCurrencyDisplayedCorrectly(data.get("currencyName")));
        Assert.assertTrue(bookingSummaryPage.isDepartFromDisplayedCorrectly(data.get("originName")));
        Assert.assertTrue(bookingSummaryPage.isDepartToDisplayedCorrectly(data.get("destinationName")));
        Assert.assertTrue(bookingSummaryPage.isReturnFromDisplayedCorrectly(data.get("destinationName")));
        Assert.assertTrue(bookingSummaryPage.isReturnToDisplayedCorrectly(data.get("originName")));

        System.out.println("Choose the cheapest tickets");
        int departFare = selectTravelOptionsPage.selectCheapestDepartTicket();
        int returnFare = selectTravelOptionsPage.selectCheapestReturnTicket();
        selectTravelOptionsPage.clickContinue();

        System.out.println("Verify that Passenger Information page displays");
        PassengerInformationPage passengerInformationPage = new PassengerInformationPage();
        Assert.assertTrue(passengerInformationPage.isPassengerInformationPageDisplayed());

        System.out.println("Verify that Information displays correctly");
        Assert.assertEquals(bookingSummaryPage.getAdultNumber(), adultNumber);
        Assert.assertEquals(bookingSummaryPage.getDepartDate(), departDateNum);
        Assert.assertEquals(bookingSummaryPage.getDepartFare(), departFare*adultNumber);
        Assert.assertEquals(bookingSummaryPage.getReturnDate(), returnDateNum);
        Assert.assertEquals(bookingSummaryPage.getReturnFare(), returnFare*adultNumber);
        Assert.assertTrue(bookingSummaryPage.isCurrencyDisplayedCorrectly(data.get("currencyName")));
        Assert.assertTrue(bookingSummaryPage.isDepartFromDisplayedCorrectly(data.get("originName")));
        Assert.assertTrue(bookingSummaryPage.isDepartToDisplayedCorrectly(data.get("destinationName")));
        Assert.assertTrue(bookingSummaryPage.isReturnFromDisplayedCorrectly(data.get("destinationName")));
        Assert.assertTrue(bookingSummaryPage.isReturnToDisplayedCorrectly(data.get("originName")));
    }
}
