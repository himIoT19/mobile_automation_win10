package eight.section;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;

public class ECommerce_TC_CodeOptimized_4 extends BaseRealECommApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");

		// hide keyboard
		driver.hideKeyboard();

		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		/*
		 * Here value changed to Added to cart, and array value decremented. So
		 * again we have to get(0)
		 */
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// sleep, so that it can select the target from current page
		Thread.sleep(4000);

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

		double sumOfProducts = 0d;
		for (int i = 0; i < count; i++) {

			String amount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText(); // $120.0
			double amountValue = getAmount(amount);
			sumOfProducts += amountValue;

		}

		System.out.println(sumOfProducts + " sum of products");
		
		String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double allProductAmount = getAmount(totalAmount);
		System.out.println(allProductAmount + " Total value of products");

		// assertEquals(double expected, double actual, double delta)
		Assert.assertEquals(sumOfProducts, allProductAmount, 0.0);
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);

		return amount2value;
	}

}
