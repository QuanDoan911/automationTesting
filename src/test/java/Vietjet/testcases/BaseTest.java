package Vietjet.testcases;

import driver.DriverManagerFactory;
import driver.DriverProperty;
import driver.DriverUtilities;
import org.testng.annotations.*;
import utilities.BrowserSettingHelper;
import utilities.JsonHelper;
import utilities.PropertiesHelper;

import java.io.File;
import java.io.IOException;

import static utilities.GlobalVariables.*;

public class BaseTest {

    public String testCaseName;
    public static PropertiesHelper propertiesHelper = null;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
        propertiesHelper = new PropertiesHelper(TEST_CONFIGURATION);

        // Validate waitTime
        SHORT_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Short_Timeout"));
        MEDIUM_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Medium_Timeout"));
        LONG_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Long_Timeout"));

        // Validate testingType
        TESTING_TYPE = propertiesHelper.getDataFromConfigurationFile("TestingType").toLowerCase();

        // Validate environment
        ENVIRONMENT = propertiesHelper.getDataFromConfigurationFile("Environment").toLowerCase();

        // Validate browserName
        BROWSER = propertiesHelper.getDataFromConfigurationFile("BrowserName").toLowerCase();

        // Validate runOn
        RUN_ON = propertiesHelper.getDataFromConfigurationFile("RunOn").toLowerCase();
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
    public void beforeMethod() throws IllegalAccessException {
        System.out.println("beforeMethod");
        DriverProperty property = BrowserSettingHelper.getDriverProperty(BROWSER+"."+RUN_ON);
        DriverManagerFactory.getDriverManager(property).setWebDriver();
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
        String DataFilePath = TEST_DATA_JSON  + File.separator +  this.getClass().getPackage().getName().replace(".", File.separator)  + File.separator + "data.json";
        Object[][] data = JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
