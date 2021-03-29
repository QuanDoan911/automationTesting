package common;

import java.io.File;
import utilities.PropertiesHelper;

public class Constants {
    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir") + File.separator + "src";
    public static final String MAIN_RESOURCES_PATH = PROJECT_PATH + File.separator + "main" + File.separator + "resources";
    public static final String TEST_RESOURCES_PATH = PROJECT_PATH + File.separator + "test" + File.separator + "resources";
    //Test data and configuration
    public static final String TEST_DATA_JSON = PROJECT_PATH + File.separator + "test" + File.separator + "java";
    public static final String TEST_CONFIGURATION = MAIN_RESOURCES_PATH + File.separator + "configuration.properties";
    public static final String BROWSER_CONFIGURATION = TEST_RESOURCES_PATH + File.separator + "browser.setting.properties";

    //Wait time
    public static final int SHORT_TIMEOUT = PropertiesHelper.getIntValue("Short_Timeout");
    public static final int MEDIUM_TIMEOUT = PropertiesHelper.getIntValue("Medium_Timeout");
    public static final int LONG_TIMEOUT = PropertiesHelper.getIntValue("Long_Timeout");

    //Run parameters
    public static final String TESTING_TYPE = PropertiesHelper.getStringValue("TestingType");
    public static final String ENVIRONMENT = PropertiesHelper.getStringValue("Environment");
    public static final String BROWSER = PropertiesHelper.getStringValue("BrowserName");
    public static final String RUN_ON = PropertiesHelper.getStringValue("RunOn");
}