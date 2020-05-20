package e2eframework.scratch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.CheckoutPage;
import pageobjects.FormPageEcomApp;
import pageobjects.ProductPage;

public class ECommerce_TC_CodeOptimized_4 extends BaseTwo {

	@Test
	public void totalValidation() throws IOException, InterruptedException {

		service = startAppiumServer();
		/*
		 * Make appName globalise so that if new version came u need not to edit
		 * in every TestCase => General-Store.apk4.0
		 */
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPageEcomApp fp = new FormPageEcomApp(driver);

		/*
		 * fp.nameField.sendKeys("Himanshu"); can't be used for logging purpose
		 * (or) we can use like below:
		 */
		fp.getNameField().sendKeys("AdItI"); // used for lgging

		// hide keyboard
		driver.hideKeyboard();

		fp.getFemaleOption().click(); // since private
		fp.getCountrySelection().click(); // since private

		Utilities utils = new Utilities(driver);
		utils.scrollToText("Argentina");

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
		Thread.sleep(4000);

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

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);

		return amount2value;
	}

}
