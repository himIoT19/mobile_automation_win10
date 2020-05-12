package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorTest extends BaseTwo {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElementByAndroidUIAutomator("attribute(value)")
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		// driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

		/*
		 * Validate "clickable" feature for all options using
		 * 'AndroidUIAutomator'. 
		 * Note: Valid locator strategies for this request: xpath, id, class name, accessibility id, -android uiautomator
		 */
		
		// driver.findElementByAndroidUIAutomator("newUiSelector().property(true)");		
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());	// its's BUG
		

	}

}
