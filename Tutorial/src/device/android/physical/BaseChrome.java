package device.android.physical;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseChrome {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = null;

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (device.equals("real")) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		} else {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HEMUA_1");
		}
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

}
