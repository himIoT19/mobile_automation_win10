package eight.section;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;

public class ECommerce_TC_4 extends BaseRealECommApp {

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
		// so that it can select the target from current page
		Thread.sleep(4000);

		String amountCartOne = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0)
				.getText(); // $120.0
		// it starts getting String from index "1" => "120.0"
		amountCartOne = amountCartOne.substring(1);
		double amountOne = Double.parseDouble(amountCartOne);

		String amountCartTwo = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1)
				.getText(); // $160.97
		// it starts getting String from index "1" => "160.97"
		amountCartTwo = amountCartTwo.substring(1);
		double amountTwo = Double.parseDouble(amountCartTwo);
		double sumOfProducts = amountOne + amountTwo;
		System.out.println(sumOfProducts + " sum of products");

		String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		totalAmount = totalAmount.substring(1);
		double total = Double.parseDouble(totalAmount);
		System.out.println(total + " Total value of products");

		// assertEquals(double expected, double actual, double delta)
		Assert.assertEquals(sumOfProducts, total, 0.0);

	}

}
