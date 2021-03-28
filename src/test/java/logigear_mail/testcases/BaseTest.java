package logigear_mail.testcases;

import driver.manage.DriverManagerFactory;
import driver.DriverProperty;
import driver.DriverUtilities;
import org.testng.annotations.*;
import utilities.BrowserSettingHelper;
import common.Constants;
import utilities.JsonHelper;

import java.io.IOException;

import static common.Constants.*;

public class BaseTest {

    public String testCaseName;

    @BeforeSuite()
    public void beforeSuite() {
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeMethod(String browser) throws IllegalAccessException {
        DriverProperty property = BrowserSettingHelper.getDriverProperty(Constants.BROWSER_CONFIGURATION, browser);
        DriverManagerFactory.createWebDriver(property);
        DriverUtilities.maximizeBrowser();
    }

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + "/" + this.getClass().getPackage().getName().replace(".", "/") + "/data.json";
        Object[][] data = JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
