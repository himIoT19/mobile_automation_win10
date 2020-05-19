package pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	AndroidDriver<AndroidElement> driver;

	/*
	 * 1. First thing is to call the driver Object from testcase to PageObject.
	 * 2. Concatenate driver defining Constructor(method name is class name)
	 * with an argument
	 */
	public CheckoutPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private AndroidElement nameField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<AndroidElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private AndroidElement totalAmount;

	/**
	 * @return the nameField
	 */
	public AndroidElement getNameField() {
		return nameField;
	}

	/**
	 * @return the productList
	 */
	public List<AndroidElement> getProductList() {
		return productList;
	}

	/**
	 * @return the totalAmount
	 */
	public AndroidElement getTotalAmount() {
		return totalAmount;
	}

	/*
	 * Combination of above two(constructor and @AndroidFindBy) is equal to step
	 * driver.findElement(By.xpath("//*[@text='Argentina']")).click(); //example
	 */

}
