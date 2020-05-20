package e2eframework.scratch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.FrameLayout;
import pageobjects.HomePage;
import pageobjects.PreferenceDependencies;
import pageobjects.Preferences;

public class ApiDemoTest extends BaseTwo {

	@Test
	public void apiDemo() throws IOException, InterruptedException {
		// START the Appium Server
		service = startAppiumServer();
		Thread.sleep(10000);

		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// xpath id className, androidUIAutomator
		/*
		 * XPath syntax //tagName[@attribute='value'] className => tagName
		 * attribute => index, text, resource-id, class, package,
		 * content-desc(core attributes) value => android.widget.TextView (NOTE:
		 * we generally pic value from 'class' attribute not always)
		 */

		// Home page(when you start the app the 1st page)
		HomePage hp = new HomePage(driver);
		// Constructor of the class will be called when Object invoked
		// if not then default constructor will be called
		// Constructor can be defined with the arguments

		/*
		 * You can call the methods or variable of the Class with Class-Object
		 */
		hp.getPreferences().click();

		// Preference Page
		Preferences pref = new Preferences(driver);

		/*
		 * You can call the methods or variable of the Class with Class-Object
		 */
		pref.getPreferenceDependencies().click();

		// Preference Dependencies Page
		PreferenceDependencies pd = new PreferenceDependencies(driver);
		pd.getWifiCheckbox().click();
		pd.getWifiSettings().click();

		// Frame Layout Page
		// to input data in text field
		FrameLayout fl = new FrameLayout(driver);
		fl.getEditText().sendKeys("hello");

		fl.getOkButton().get(1).click();
		// get(1) => handle duplicate instances

		// STOP the Appium Server so that other TC cn not be affected.
		service.stop();
	}

}
