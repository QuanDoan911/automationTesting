package vietjet.testcases;

import common.Constants;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            System.out.println("Test");
            Thread.sleep(Constants.MEDIUM_TIMEOUT * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
