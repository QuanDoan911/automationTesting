package common;

import utilities.PropertiesHelper;

public class Constants {
    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String MAIN_RESOURCES_PATH = PROJECT_PATH + "\\src\\main\\resources";
    public static final String TEST_RESOURCES_PATH = PROJECT_PATH + "\\src\\test\\resources";
    //Test data and configuration
    public static final String TEST_DATA_JSON = PROJECT_PATH + "\\src\\test\\java";
    public static final String TEST_CONFIGURATION = MAIN_RESOURCES_PATH + "\\config.properties";
    public static final String BROWSER_CONFIGURATION = TEST_RESOURCES_PATH + "\\browser.setting.properties";

    //Wait time
    public static final int SHORT_TIMEOUT = PropertiesHelper.getInt("Short_Timeout");
    public static final int MEDIUM_TIMEOUT = PropertiesHelper.getInt("Medium_Timeout");
    public static final int LONG_TIMEOUT = PropertiesHelper.getInt("Long_Timeout");

    //Run parameters
    public static final String TESTING_TYPE = PropertiesHelper.getPropValue("TestingType");
    public static final String ENVIRONMENT = PropertiesHelper.getPropValue("Environment");
    public static final String BROWSER = PropertiesHelper.getPropValue("BrowserName");
    public static final String RUN_ON = PropertiesHelper.getPropValue("RunOn");
}