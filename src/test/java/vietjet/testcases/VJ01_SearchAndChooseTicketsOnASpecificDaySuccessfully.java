package vietjet.testcases;

import common.Constants;
import driver.DriverUtilities;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            DriverUtilities.navigateToTestSite("https://www.vietjetair.com/Sites/Web/en-US/Home");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
