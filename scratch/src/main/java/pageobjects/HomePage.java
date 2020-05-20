package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All the Objects belonging to one page will be defined in Java Class
public class HomePage {
	AndroidDriver<AndroidElement> driver;

	/*
	 * 1. First thing is to call the driver Object from testcase to PageObject.
	 * 2. Concatenate driver defining Constructor(method name is class name)
	 * with an argument
	 */
	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	private AndroidElement Preferences;
	// findElementByXPath("//android.widget.TextView[@text='Preference']")

	/*
	 * Combination of above two(constructor and @AndroidFindBy) is equal to step
	 */
	// "driver.findElementByXPath("//android.widget.TextView[@text='Preference']")"

	public AndroidElement getPreferences() {
		return Preferences;
	}

}
