package basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseOne {

//	public static void main(String[] args) throws MalformedURLException {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		//		path for apk get using file system
		File f = new File("src");
		File fs = new File(f, "original.apk");
		
		// Class: Test Case and Project: Test Suite
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//		Successfully added this capabilitiesability
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HEMUA_1");
		
		//		Successfully added this capabilitiesability(GET path for APK) app info.
		//		capabilities.setCapability(MobileCapabilityType.APP, "E:\Workspaces\Appium_Mobile_Automation\WS_appium\Tutorial\src\original.apk");
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		//		Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android.
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		
		//		Connection to server(using driver object)
		// 1st arg:  cnnectiontoserverlink
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
		
		
	}

}