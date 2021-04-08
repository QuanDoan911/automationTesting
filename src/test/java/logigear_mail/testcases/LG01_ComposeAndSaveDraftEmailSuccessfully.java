package logigear_mail.testcases;

import driver.DriverUtilities;
import logigear_mail.pages.LoginPage;
import org.testng.annotations.Test;
import vietjet.testcases.BaseTest;

import static common.Constants.*;

import java.util.Hashtable;

public class LG01_ComposeAndSaveDraftEmailSuccessfully extends BaseTest {
    @Test(dataProvider = "getDataForTest", priority = 1, description = "Compose and save draft email successfully")
    public void TC01(Hashtable<String, String> data) {
        System.out.println("Navigate to test site");
        DriverUtilities.navigateToTestSite(LGMAIL_URL);

        System.out.println("Login");
        LoginPage loginPage = new LoginPage();
        loginPage.login(LG_USERNAME, LG_PASSWORD, true);

        System.out.println("Compose new email with attachment");
    }
}
