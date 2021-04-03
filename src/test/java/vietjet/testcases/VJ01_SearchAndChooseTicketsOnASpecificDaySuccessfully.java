package vietjet.testcases;

import common.Constants;
import driver.DriverUtilities;
import org.testng.annotations.Test;
import vietjet.pages.HomePage;

import java.util.Hashtable;


public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            DriverUtilities.navigateToTestSite("https://www.vietjetair.com/Sites/Web/en-US/Home");
            HomePage.getInstance().searchFlights(Boolean.parseBoolean(data.get("isReturndata")),data.get("groupOrigin"), data.get("origin"), data.get("groupDestination"), data.get("destination") , data.get("departDate") , data.get("returnDate"), data.get("currency"), Boolean.parseBoolean(data.get("isFindLowestPrice")), Integer.parseInt(data.get("adultsNum")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
