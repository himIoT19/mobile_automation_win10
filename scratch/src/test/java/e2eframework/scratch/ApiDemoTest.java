package e2eframework.scratch;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.FrameLayout;
import pageobjects.HomePage;
import pageobjects.PreferenceDependencies;
import pageobjects.Preferences;

public class ApiDemoTest extends BaseTwo {

	@Test(dataProvider = "InputData", dataProviderClass = TestDataApiDemo.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException {
		// START the Appium Server
		service = startAppiumServer();
		Thread.sleep(5000);

		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");

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
		fl.getEditText().sendKeys(input);

		// get(1) => handle duplicate instances
		fl.getOkButton().get(1).click();

		// STOP the Appium Server so that other TC cn not be affected.
		service.stop();
	}

	@BeforeTest
	public void killAllNodesAppiumServer() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(2000);
	}

}
