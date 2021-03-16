package constants;

public class Constants {
    public static final int SHORT_TIMEOUT = 10;
    public static final int MEDIUM_TIMEOUT = 30;
    public static final int LONG_TIMEOUT = 60;

    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir")+"/src";
    public static final String MAIN_RESOURCES_PATH = PROJECT_PATH + "/main/resources";

    //Test data and configuration
    public static final String TEST_DATA_JSON = PROJECT_PATH + "/test/java";
    public static final String TEST_CONFIGURATION = MAIN_RESOURCES_PATH + "configuration/Configuration.properties";
}
