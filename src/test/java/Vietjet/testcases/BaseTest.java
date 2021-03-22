package Vietjet.testcases;

import driver.DriverManagerFactory;
import driver.DriverProperty;
import driver.DriverUtilities;
import org.testng.annotations.*;
import utilities.BrowserSettingHelper;
import utilities.JsonHelper;
import utilities.PropertiesHelper;

import java.io.IOException;

import static utilities.GlobalVariables.*;

public class BaseTest {

    public String testCaseName;

    //Initiate variable for log4j
    public static PropertiesHelper propertiesHelper = null;

    @BeforeSuite()
    public void beforeSuite() {

        // Initial test data
        propertiesHelper = new PropertiesHelper(TEST_CONFIGURATION);

        // Validate wait time
        SHORT_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Short_Timeout"));
        MEDIUM_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Medium_Timeout"));
        LONG_TIMEOUT = Integer.parseInt(propertiesHelper.getDataFromConfigurationFile("Long_Timeout"));

        // Validate testingType
        TESTING_TYPE = propertiesHelper.getDataFromConfigurationFile("TestingType");

        // Validate environment
        ENVIRONMENT = propertiesHelper.getDataFromConfigurationFile("Environment");
    }
    @BeforeClass
    public synchronized void beforeClass(){
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeMethod(@Optional String browser) throws IllegalAccessException {
        DriverProperty property = BrowserSettingHelper.getDriverProperty("browser");
        DriverManagerFactory.getDriverManager(property).setWebDriver();
        DriverUtilities.maximizeBrowser();
    }

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + "/" + this.getClass().getPackage().getName().replace(".", "/") + "/data.json";
        Object[][] data = JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
