package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollinDemo extends BaseTwo {

	public static void main(String[] args) throws MalformedURLException {

		// get capabilities from base class "BaseTwo" using 'extends'
		AndroidDriver<AndroidElement> driver = capabilities();

		/*
		 * It's not something that you call to wait for 10 seconds, it only
		 * comes into play when an element that is being searched for is not
		 * available... then the implicit wait is triggered and that element is
		 * polled up to the 10s. If the element is already there, then there is
		 * no wait time. Thread.sleep() pauses execution no matter what but is
		 * not a good practice.
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get locator for "Views" using Xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

		/*
		 * Appium is not supporting any method for "Scrolling-Down", previously
		 * there is. So, we have to bring AndroidAPI to AppiumAPI to execute
		 */
		/*
		 * driver.findElementsByAndroidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"
		 * );
		 */
		driver.findElementsByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");

	}

}
