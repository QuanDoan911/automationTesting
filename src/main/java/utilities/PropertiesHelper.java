package utilities;

import driver.DriverUtilities;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties conf, profile;
    private static final Logger logger = Logger.getLogger(DriverUtilities.class);

    private static Properties propsForName(String propFileName) {
        InputStream inputStream = null;
        try {
            logger.info("Loading properties : " + propFileName);
            inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                Properties prop = new Properties();
                prop.load(inputStream);
                return prop;
            } else {
                logger.info(propFileName + " not found !");
                return null;
            }
        } catch (Exception e) {
            logger.info("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    private static void initProps() {
        if (conf == null) {
            conf = propsForName("config.properties");
        }

        if (profile == null) {
            String profile = System.getProperty("profile");
            if (profile != null)
                PropertiesHelper.profile = propsForName("profiles/" + profile + ".properties");
            else
                PropertiesHelper.profile = propsForName("profiles/qa.properties");
        }
    }

    public static String getStringValue(String key) {
        return getPropValue(key, null);
    }

    public static int getIntValue(String key) {
        String value = getPropValue(key, null);
        return Integer.parseInt(value);
    }

    public static double getDoubleValue(String key) {
        String value = getPropValue(key, null);
        return Double.parseDouble(value);
    }

    public static boolean getBooleanValue(String key) {
        String value = getPropValue(key, null);
        return Boolean.parseBoolean(value);
    }

    public static String getPropValue(String key, String defaultValue) {
        initProps();
        if (System.getProperty(key) != null)
            return System.getProperty(key);

        if (profile != null && profile.containsKey(key))
            return profile.getProperty(key);

        if (conf != null && conf.containsKey(key))
            return conf.getProperty(key);
        return defaultValue;
    }
}

