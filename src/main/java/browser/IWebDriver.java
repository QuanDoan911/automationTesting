package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public interface IWebDriver {
    void createWebDriver();

    WebDriver getWebDriver();

    void setWebDriver();

    String getRemoteUrl();

    void setRemoteUrl(String remoteUrl);

    List<String> getArguments();

    void setArguments(List<String> arguments);

    DesiredCapabilities getCapabilities();

    void setCapabilities(DesiredCapabilities capabilities);
}
