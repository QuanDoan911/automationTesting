package vietjet.testcases;

import driver.DriverUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeHelper;
import vietjet.pages.HomePage;
import vietjet.pages.PassengerInformationPage;
import vietjet.pages.SelectTravelOptionsPage;

import java.util.Hashtable;

public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            String departDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToDepartDate")));
            String returnDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToReturnDate")));
            int adultNumber = Integer.parseInt(data.get("adultsNum"));
            int departPrice;
            int returnPrice;

            System.out.println("Navigate to test site");
            DriverUtilities.navigateToTestSite("https://www.vietjetair.com/Sites/Web/en-US/Home");

            System.out.println("Search flight");
            HomePage.getInstance().searchFlights(Boolean.parseBoolean(data.get("isReturn")),data.get("origin"), data.get("destination") , departDate,returnDate, data.get("currency"), Boolean.parseBoolean(data.get("isFindLowestPrice")), adultNumber);

            System.out.println("Verify point");
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isSelectTravelOptionsPageDisplayed());
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isCurrencyDisplaysCorrect(data.get("currencyName")));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isAdultNumberDisplaysCorrect(adultNumber));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isDepartDateDisplaysCorrect(departDate));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isDepartFromDisplaysCorrect(data.get("originName")));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isDepartToDisplaysCorrect(data.get("destinationName")));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isReturnDateDisplaysCorrect(returnDate));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isReturnFromDisplaysCorrect(data.get("destinationName")));
            Assert.assertTrue(SelectTravelOptionsPage.getInstance().isReturnToDisplaysCorrect(data.get("originName")));

            System.out.println("Choose the cheapest tickets");
            departPrice = SelectTravelOptionsPage.getInstance().selectCheapestDepartTicket();
            returnPrice = SelectTravelOptionsPage.getInstance().selectCheapestReturnTicket();
            SelectTravelOptionsPage.getInstance().clickContinue();

            System.out.println("Verify point");
            Assert.assertTrue(PassengerInformationPage.getInstance().isPassengerInformationPageDisplayed());
            Assert.assertTrue(PassengerInformationPage.getInstance().isCurrencyDisplaysCorrect(data.get("currencyName")));
            Assert.assertTrue(PassengerInformationPage.getInstance().isAdultNumberDisplaysCorrect(adultNumber));
            Assert.assertTrue(PassengerInformationPage.getInstance().isDepartDateDisplaysCorrect(departDate));
            Assert.assertTrue(PassengerInformationPage.getInstance().isDepartFareDisplaysCorrect(departPrice*adultNumber));
            Assert.assertTrue(PassengerInformationPage.getInstance().isDepartFromDisplaysCorrect(data.get("originName")));
            Assert.assertTrue(PassengerInformationPage.getInstance().isDepartToDisplaysCorrect(data.get("destinationName")));
            Assert.assertTrue(PassengerInformationPage.getInstance().isReturnDateDisplaysCorrect(returnDate));
            Assert.assertTrue(PassengerInformationPage.getInstance().isReturnFareDisplaysCorrect(returnPrice*adultNumber));
            Assert.assertTrue(PassengerInformationPage.getInstance().isReturnFromDisplaysCorrect(data.get("destinationName")));
            Assert.assertTrue(PassengerInformationPage.getInstance().isReturnToDisplaysCorrect(data.get("originName")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
