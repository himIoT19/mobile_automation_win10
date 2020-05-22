package e2eframework.scratch;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.CheckoutPage;
import pageobjects.FormPageEcomApp;
import pageobjects.ProductPage;

public class EcommerceCodeOptimized4Test extends BaseTwo {

	@Test(dataProvider = "InputData", dataProviderClass = TestDataEcommerce.class)
	public void totalValidation(String inputText, String countryName) throws IOException, InterruptedException {

		service = startAppiumServer();
		Thread.sleep(5000);

		/*
		 * Make appName globalise so that if new version came u need not to edit
		 * in every TestCase => General-Store.apk4.0
		 */
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");

		FormPageEcomApp fp = new FormPageEcomApp(driver);

		/*
		 * fp.nameField.sendKeys("Himanshu"); can't be used for logging purpose
		 * (or) we can use like below:
		 */
		fp.getNameField().sendKeys(inputText); // used for lgging

		// hide keyboard
		driver.hideKeyboard();

		fp.getFemaleOption().click(); // since private
		fp.getCountrySelection().click(); // since private

		Utilities utils = new Utilities(driver);
		utils.scrollToText(countryName);

		fp.getCountryScroll().click();
		fp.getLetsShop().click();

		// Product page
		ProductPage pp = new ProductPage(driver);
		pp.getProduct1().get(0).click();
		// driver.findElements(By.xpath("//*[@text='ADD TO
		// CART']")).get(0).click();
		/*
		 * Here value changed to Added to cart, and array value decremented. So
		 * again we have to get(0)
		 */
		pp.getProduct2().get(0).click();
		pp.getGotoCart().click();

		// sleep, so that it can select the target from current page
		Thread.sleep(2000);

		// Checkout Page
		CheckoutPage ckp = new CheckoutPage(driver);
		int count = ckp.getProductList().size();
		double sumOfProducts = 0d;

		for (int i = 0; i < count; i++) {

			String amount = ckp.getProductList().get(i).getText(); // $120.0
			double amountValue = getAmount(amount);
			sumOfProducts += amountValue;

		}

		System.out.println(sumOfProducts + " sum of products");

		String totalAmount = ckp.getTotalAmount().getText();
		double allProductAmount = getAmount(totalAmount);
		System.out.println(allProductAmount + " Total value of products");

		// assertEquals(double expected, double actual, double delta)
		Assert.assertEquals(sumOfProducts, allProductAmount, 0.0);

		// STOP Appium server, because it is not the only TC we are executing
		service.stop();
	}

	@BeforeTest
	public void killAllNodesAppiumServer() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(2000);
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);

		return amount2value;
	}

}
