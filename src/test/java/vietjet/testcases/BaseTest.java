package vietjet.testcases;

import common.Constants;
import driver.DriverProperty;
import driver.DriverUtilities;
import driver.manage.DriverManagerFactory;
import org.testng.annotations.*;
import utilities.BrowserSettingHelper;
import utilities.JsonHelper;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public String testCaseName;

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
        testCaseName = this.getClass().getSimpleName();
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws IllegalAccessException {
        System.out.println("beforeMethod");
        DriverProperty property = BrowserSettingHelper.getDriverProperty(Constants.BROWSER_CONFIGURATION, browser);
        DriverManagerFactory.createWebDriver(property);
        DriverUtilities.maximizeBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
        DriverUtilities.closeBrowser();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = Constants.TEST_DATA_JSON + File.separator + this.getClass().getPackage().getName().replace(".", File.separator) + File.separator + "data.json";
        Object[][] data = JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
