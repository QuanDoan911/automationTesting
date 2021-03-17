package testcases;

import org.testng.annotations.*;
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

    @BeforeClass
    public void beforeClass(){
    }

    @BeforeMethod
    public void beforeMethod(){
    }

    @AfterMethod
    public void afterMethod(){
    }

    @AfterClass()
    public void afterClass(){
    }

    @AfterSuite()
    public void afterSuite(){
    }


    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + this.getClass().getPackage().getName().replace(".","/") + "/data.json";
        Object[][] data =  JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
