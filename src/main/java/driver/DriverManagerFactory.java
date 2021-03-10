package driver;

import browsermanager.chrome.ChromeDriverManager;
import browsermanager.firefox.FirefoxDriverManager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverProperty property) {
        DriverManager driverManager;
        switch (property){
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
