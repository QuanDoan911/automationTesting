package utilities;

import java.io.File;

public class GlobalVariables {
    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir") + File.separator + "src";
    public static final String MAIN_RESOURCES_PATH = PROJECT_PATH + File.separator + "main" + File.separator + "resources";
    public static final String TEST_RESOURCES_PATH = PROJECT_PATH + File.separator + "test" + File.separator + "resources";
    //Test data and configuration
    public static final String TEST_DATA_JSON = PROJECT_PATH + File.separator + "test" + File.separator + "java";
    public static final String TEST_CONFIGURATION = MAIN_RESOURCES_PATH + File.separator + "configuration.properties";
    public static final String BROWSER_CONFIGURATION = TEST_RESOURCES_PATH + File.separator + "browser.setting.properties";
    //Wait time
    public static int SHORT_TIMEOUT;
    public static int MEDIUM_TIMEOUT;
    public static int LONG_TIMEOUT;
    //Run parameters
    public static String TESTING_TYPE = "";
    public static String ENVIRONMENT = "";
    public static String BROWSER = "";
    public static String RUN_ON = "";

}
