package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends BaseTwo {

	@SuppressWarnings("rawtypes")
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

		// get locator for "Drag and Drop" using Xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

		// since many options with the same class name
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(2);

		// We need TouchAction for dragging
		TouchAction t = new TouchAction(driver);
		// longpress(source)//move(destination)//release => doing manually
		// t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();

		t.longPress(element(source)).moveTo(element(destination)).release().perform();
	}

}
