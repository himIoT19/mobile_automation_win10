package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPageEcomApp {

	@SuppressWarnings("unused")
	private AndroidDriver<AndroidElement> driver;

	/*
	 * 1. First thing is to call the driver Object from testcase to PageObject.
	 * 2. Concatenate driver defining Constructor(method name is class name)
	 * with an argument
	 */
	public FormPageEcomApp(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private AndroidElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private AndroidElement femaleOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private AndroidElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	private AndroidElement countrySelection;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	private AndroidElement countryScroll;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private AndroidElement letsShop;

	/**
	 * @return the nameField
	 */
	public AndroidElement getNameField() {
		return nameField;
	}

	/**
	 * @return the femaleOption
	 */
	public AndroidElement getFemaleOption() {
		return femaleOption;
	}

	/**
	 * @return the maleOption
	 */
	public AndroidElement getMaleOption() {
		return maleOption;
	}

	/**
	 * @return the countrySelection
	 */
	public AndroidElement getCountrySelection() {
		return countrySelection;
	}

	/**
	 * @return the countryScroll
	 */
	public AndroidElement getCountryScroll() {
		return countryScroll;
	}

	/**
	 * @return the letsShop
	 */
	public AndroidElement getLetsShop() {
		return letsShop;
	}

	/*
	 * Combination of above two(constructor and @AndroidFindBy) is equal to step
	 * driver.findElement(By.xpath("//*[@text='Argentina']")).click(); //example
	 */

}
