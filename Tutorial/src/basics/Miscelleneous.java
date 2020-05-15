package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscelleneous extends BaseTwo {

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
		
		System.out.println(driver.currentActivity());
		System.out.println(driver.getContext());
		// views - Native, Hybrid, Webview
		System.out.println(driver.getOrientation());
		System.out.println(driver.isDeviceLocked());
		// driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		
	}

}
