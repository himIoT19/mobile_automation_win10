package device.android.physical;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Recycle {
	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver;

		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, "original.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
		// "Rahulemulator");
		if (device.equals("real"))
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		else
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HEMUA_1");
		// capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
		// "chrome");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

}