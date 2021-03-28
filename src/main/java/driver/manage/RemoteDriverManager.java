package driver.manage;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class RemoteDriverManager extends DriverManager {

	protected URL getRemoteUrl() {
		try {
			return new URL(this.remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
