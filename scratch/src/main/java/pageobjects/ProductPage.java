package pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {

	@SuppressWarnings("unused")
	private AndroidDriver<AndroidElement> driver;

	/*
	 * 1. First thing is to call the driver Object from testcase to PageObject.
	 * 2. Concatenate driver defining Constructor(method name is class name)
	 * with an argument
	 */
	public ProductPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private List<AndroidElement> product1;

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private List<AndroidElement> product2;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private AndroidElement gotoCart;

	/**
	 * @return the product1
	 */
	public List<AndroidElement> getProduct1() {
		return product1;
	}

	/**
	 * @return the product2
	 */
	public List<AndroidElement> getProduct2() {
		return product2;
	}

	/**
	 * @return the gotoCart
	 */
	public AndroidElement getGotoCart() {
		return gotoCart;
	}

	/*
	 * Combination of above two(constructor and @AndroidFindBy) is equal to step
	 * driver.findElement(By.xpath("//*[@text='Argentina']")).click(); //example
	 */

}
