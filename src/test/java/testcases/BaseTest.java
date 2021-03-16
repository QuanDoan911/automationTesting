package testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import utilities.ConfigFileReader;

import static constants.Constants.*;
import utilities.JsonHelper;

import java.io.IOException;

public class BaseTest {

    public String testCaseName;

    //Initiate variable for log4j
    public static ConfigFileReader configFileReader = null;

    @BeforeSuite()
    public void beforeSuite(){
        // Initial test data
        try {
            String testDataFilePath = TEST_CONFIGURATION;
            configFileReader = new ConfigFileReader(testDataFilePath);
        } catch (Exception e) {
        }
    }
//
//    @BeforeClass
//    public void beforeClass() throws IOException {
//    }
//
//    @BeforeMethod
//    public void beforeMethod(Object[] data) throws IOException {
//        log4j.info("beforeMethod method - Start");
//        logStep = null;
//        TOTAL_EXECUTED++;
//
//        if(data != null && data.length > 0) {
//            // Get test data for test case
//            Hashtable<String, String> dataTest = (Hashtable<String, String>) data[0];
//
//            //Get Retry count
//            if (RETRY_FAILED_TESTS.equalsIgnoreCase("Yes")) {
//                int retryCount = getRetryCount(testcaseList, testCaseName + ": " + dataTest.get("No."));
//                if (retryCount > 0) {
//                    testNameWithStatus = testCaseName + ": " + dataTest.get("No.") + ": RETRY" + retryCount;
//                    //logMethod.assignCategory("RETRY");
//                } else {
//                    testNameWithStatus = testCaseName + ": " + dataTest.get("No.");
//                }
//            } else {
//                testNameWithStatus = testCaseName + ": " + dataTest.get("No.");
//            }
//
//            //Initialize logClass
//            logClass = TestReporter.createTestForExtentReport(report, testNameWithStatus);
//
//            // Initial logMethod
//            logMethod = TestReporter.createNodeForExtentReport(logClass, dataTest.get("TestDataPurpose"));
//            log4j.info(dataTest.get("No.") + ": " + dataTest.get("TestDataPurpose"));
//
//            // Assign test category
//            logMethod.assignCategory(dataTest.get("TestingType"));
//
//            // Start web driver and initialize Digital Zoom report
//            if (isTestDataExecutable(dataTest, logMethod)) {
//                initializeDriver(logMethod);
//                reportiumClient = DigitalZoomReport.initDigitalZoomReport(Utility.getDriver());
//            }
//
//            log4j.info("beforeMethod method - End");
//        }
//        else{
//            logClass = TestReporter.createTestForExtentReport(report, testCaseName);
//            TestReporter.logSkip(logClass, "This test case has no data to run");
//        }
//    }
//
//    @AfterMethod
//    public void afterMethod() throws IOException {
//    }
//
//    @AfterClass()
//    public void afterClass() throws IOException {
//    }
//
//    @AfterSuite()
//    public void afterSuite(ITestContext context) throws Exception {
//    }
//

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + this.getClass().getPackage().getName().replace(".","/") + "/data.json";
        Object[][] data =  JsonHelper.getData(testCaseName, DataFilePath);
        return data;
    }
}
