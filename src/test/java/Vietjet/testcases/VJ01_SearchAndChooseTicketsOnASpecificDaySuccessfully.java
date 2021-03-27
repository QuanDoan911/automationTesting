package Vietjet.testcases;

import org.testng.annotations.Test;
import java.util.Hashtable;

import static utilities.GlobalVariables.SHORT_TIMEOUT;

public class VJ01_SearchAndChooseTicketsOnASpecificDaySuccessfully extends BaseTest{
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC01(Hashtable<String, String> data) {
        try {
            System.out.println("Test");
            Thread.sleep(SHORT_TIMEOUT*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
