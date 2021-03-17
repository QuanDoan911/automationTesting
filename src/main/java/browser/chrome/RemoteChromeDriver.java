package browser.chrome;

import java.net.MalformedURLException;
import java.net.URL;

import driver.DriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeDriver extends DriverManager {
	@Override
	public void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments(getArguments());
		options.merge(getCapabilities());
		try {
			this.driver = new RemoteWebDriver(new URL(getRemoteUrl()), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
