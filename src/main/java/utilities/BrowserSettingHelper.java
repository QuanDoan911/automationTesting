package utilities;

import driver.DriverProperty;
import static utilities.GlobalVariables.*;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class BrowserSettingHelper {

	public static <T> Section getData(String filePath, String sectionHeader) {
		return getIniReader(filePath).get(sectionHeader);
	}

	private static Wini getIniReader(String filePath) {
		Wini ini = null;
		try {
			ini = new Wini(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ini;
	}

	public static DriverProperty getDriverProperty(String section) {
		DriverProperty property = new DriverProperty();
		Section data = getData(BROWSER_CONFIGURATION, section);
		String mode = data.get("mode");
		String driver = data.get("driver");
		String remoteUrl = data.get("remoteUrl");
		String capabilities = data.get("capabilities");
		String arguments = data.get("arguments");
		property.setMode(mode);
		property.setDriver(driver);
		property.setRemoteUrl(remoteUrl);
		property.setArguments(arguments);
		property.setCapabilities(capabilities);

		return property;
	}

}