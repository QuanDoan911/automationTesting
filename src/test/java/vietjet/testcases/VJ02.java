package vietjet.testcases;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import common.Constants;
import driver.DriverUtilities;
import org.testng.annotations.Test;
import utilities.DateTimeHelper;
import vietjet.pages.HomePage;

import java.util.Hashtable;

public class VJ02 extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Search and choose tickets on a specific day successfully")
    public void TC02(Hashtable<String, String> data) {
            String departDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToDepartDate")), "");
            String returnDate = DateTimeHelper.getDayFarFromCurrent(Integer.parseInt(data.get("currentDateToReturnDate")), "");

            DriverUtilities.navigateToTestSite(Constants.VIETJET_VI_URL);
            HomePage.getInstance().searchFlights(Boolean.parseBoolean(data.get("isReturndata")), data.get("origin"), data.get("destination"), departDate, returnDate, data.get("currency"), Boolean.parseBoolean(data.get("isFindLowestPrice")), Integer.parseInt(data.get("adultsNum")));
    }
}
