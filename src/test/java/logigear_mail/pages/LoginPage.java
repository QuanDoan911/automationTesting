package logigear_mail.pages;

import driver.DriverUtilities;
import element.common.imp.Button;
import element.common.imp.CheckBox;
import element.common.imp.TextBox;

import static common.Constants.MEDIUM_TIMEOUT;
import static common.Constants.SHORT_TIMEOUT;

public class LoginPage extends BasePage {

    public LoginPage() {
        DriverUtilities.waitForJQuery(MEDIUM_TIMEOUT);
    }

    Button btnLogOn = new Button("id=SubmitCreds");
    CheckBox chkPublicComputer = new CheckBox("id=rdoPublic");
    CheckBox chkPrivateComputer = new CheckBox("id=rdoTrusted");
    TextBox txtUsername = new TextBox("id=username");
    TextBox txtPassword = new TextBox("id=password");

    void clickLogOn() {
        btnLogOn.waitForClickable(SHORT_TIMEOUT);
        btnLogOn.click();
    }

    void inputUsername(String username) {
        txtUsername.waitForClickable(SHORT_TIMEOUT);
        txtUsername.enter(username);
    }

    void inputPassword(String password) {
        txtPassword.waitForClickable(SHORT_TIMEOUT);
        txtPassword.enter(password);
    }

    public void login(String username, String password, boolean isPublic) {
        inputUsername(username);
        inputPassword(password);
        selectSecurityLevel(isPublic);
        clickLogOn();
    }

    void selectSecurityLevel(boolean isPublic) {
        if (isPublic) {
            chkPublicComputer.waitForClickable(SHORT_TIMEOUT);
            chkPublicComputer.check();
        } else {
            chkPrivateComputer.waitForClickable(SHORT_TIMEOUT);
            chkPrivateComputer.check();
        }
    }

}
