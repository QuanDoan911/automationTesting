package testcases;

import driver.DriverManagerFactory;
import driver.DriverProperty;
import driver.DriverUtilities;
import org.testng.annotations.*;
import utilities.BrowserSettingHelper;
import utilities.PropertiesHelper;

import static globalvariables.GlobalVariables.*;

import utilities.JsonHelper;

import java.io.IOException;

public class BaseTest {

    public String testCaseName;

    //Initiate variable for log4j
    public static PropertiesHelper propertiesHelper = null;

    @BeforeSuite()
    public void beforeSuite() {

        // Initial test data
        propertiesHelper = new PropertiesHelper(TEST_CONFIGURATION);

        // Validate testingType
        TESTING_TYPE = propertiesHelper.getDataFromConfigurationFile("TestingType");

        // Validate environment
        ENVIRONMENT = propertiesHelper.getDataFromConfigurationFile("Environment");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeMethod(@Optional String browser) throws IllegalAccessException {
        DriverProperty property = BrowserSettingHelper.getDriverProperty(browser);
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
