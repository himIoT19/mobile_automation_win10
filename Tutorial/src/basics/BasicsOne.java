package basics;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicsOne extends BaseTwo { // inheriting capabilities

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// xpath id className, androidUIAutomator
		/*
		 * XPath syntax //tagName[@attribute='value'] className => tagName
		 * attribute => index, text, resource-id, class, package,
		 * content-desc(core attributes) value => android.widget.TextView (NOTE:
		 * we generally pic value from 'class' attribute not always)
		 */

		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();

		/*
		 * When nothing is unique: class => android.widget.RelativeLayout TRICK:
		 * (android.widget.RelativeLayout).[2]
		 */
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello"); // to
																					// input
																					// data
																					// in
																					// text
																					// field
		// driver.findElementById("android:id/button1").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click(); // handle
																				// duplicate
																				// instances

	}

}
