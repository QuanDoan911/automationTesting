package utilities;

import driver.DriverUtilities;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties _conf, _profile;
    private static final Logger logger = Logger.getLogger(DriverUtilities.class);

    private static Properties _propsForName(String propFileName) {
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

    private static void _initProps() {
        if (_conf == null) {
            _conf = _propsForName("conf.properties");
        }

        if (_profile == null) {
            String profile = System.getProperty("profile");
            if (profile != null)
                _profile = _propsForName("profiles/" + profile + ".properties");
            else
                _profile = _propsForName("profiles/qa.properties");
        }
    }

    public static String getPropValue(String key) {
        return getPropValue(key, null);
    }

    public static int getInt(String key) {
        String value = getPropValue(key, null);
        return Integer.parseInt(value);
    }

    public static double getDouble(String key) {
        String value = getPropValue(key, null);
        return Double.parseDouble(value);
    }

    public static boolean getBoolean(String key) {
        String value = getPropValue(key, null);
        return Boolean.parseBoolean(value);
    }

    public static String getPropValue(String key, String defaultValue) {
        _initProps();
        if (System.getProperty(key) != null)
            return System.getProperty(key);

        if (_profile != null && _profile.containsKey(key))
            return _profile.getProperty(key);

        if (_conf != null && _conf.containsKey(key))
            return _conf.getProperty(key);
        return defaultValue;
    }
}

