package PracticalTestCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.HomePage;
import pageobjects.Preferences;

public class BasicTest extends BaseFile {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// xpath id className, androidUIAutomator
		/*
		 * XPath syntax //tagName[@attribute='value'] className => tagName
		 * attribute => index, text, resource-id, class, package,
		 * content-desc(core attributes) value => android.widget.TextView (NOTE:
		 * we generally pic value from 'class' attribute not always)
		 */

		HomePage hp = new HomePage(driver);
		// Constructor of the class will be called when Object invoked
		// if not then default constructor will be called
		// Constructor can be defined with the arguments

		/*
		 * You can call the methods or variable of the Class with Class-Object
		 */
		hp.Preferences.click();

		// driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		Preferences pref = new Preferences(driver);

		/*
		 * You can call the methods or variable of the Class with Class-Object
		 */
		pref.PreferenceDependencies.click();

		/*
		 * driver.
		 * findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']"
		 * ).click();
		 */
		driver.findElementById("android:id/checkbox").click();

		/*
		 * When nothing is unique: class => android.widget.RelativeLayout TRICK:
		 * (android.widget.RelativeLayout).[2]
		 */
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

		// to input data in text field
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");

		// driver.findElementById("android:id/button1").click();
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		// get(1) => handle duplicate instances

	}

}
