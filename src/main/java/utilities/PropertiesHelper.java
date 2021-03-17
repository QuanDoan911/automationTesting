package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {

    private Properties prop = null;

    //Constructor for ConfigFileReader class
    public PropertiesHelper(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {

        }
    }

    /*
     *  This method is used to get config values from configuration.properties file
     *  Input: config parameter name
     *  Output: config parameter value
     */
    public String getDataFromConfigurationFile(String configParameter) {
        String configValue = null;
        try {
            configValue = prop.getProperty(configParameter).trim();

        } catch (Exception e) {
        }
        return configValue;
    }
}
