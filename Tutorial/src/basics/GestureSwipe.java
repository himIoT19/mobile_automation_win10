package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class GestureSwipe extends BaseTwo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws MalformedURLException {

		// get capabilities from base class "BaseTwo" using 'extends'
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get locator for "Views" using Xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

		// get locator for "Date Widgets" using Xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();

		// get locator for "2. Inline" using AndroidUIAutomator
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

		// (or) // get locator for "2. Inline" using Xpath
		// driver.findElementByXPath("//android.widget.TextView[@text='2.
		// Inline']").click();

		/*
		 * Get locator for Watch time click at "9" using Xpath method here.
		 * NOTE: Ifthereare some special characters in tagname we are using
		 * "tagName"
		 * "android.widget.RadialTimePickerView$RadialPickerTouchHelper" here.
		 * So, we cant use that, but we can use "*" (any tagName acceptable).
		 */
		driver.findElementByXPath("//*[@content-desc='9']").click();

		// Swipe scenario

		// import io.appium.java_client.TouchAction;
		TouchAction t = new TouchAction(driver);

		/*
		 * long press -> on element -> for x secs -> move to another element ->
		 * and then you release
		 */
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second))
				.release().perform();

		// Select "AM" or "PM"
		driver.findElementByXPath("//android.widget.RadioButton[@text='PM']").click();

	}

}
