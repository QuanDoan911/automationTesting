package vietjet.testcases;

import driver.DriverUtilities;
import org.testng.annotations.Test;
import utilities.DateTimeHelper;
import vietjet.pages.HomePage;

import java.util.Hashtable;

public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            String departDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToDepartDate")), "");
            String returnDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToReturnDate")), "");

            DriverUtilities.navigateToTestSite("https://www.vietjetair.com/Sites/Web/en-US/Home");
            HomePage.getInstance().searchFlights(Boolean.parseBoolean(data.get("isReturndata")),data.get("origin"), data.get("destination") , departDate,returnDate, data.get("currency"), Boolean.parseBoolean(data.get("isFindLowestPrice")), Integer.parseInt(data.get("adultsNum")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
