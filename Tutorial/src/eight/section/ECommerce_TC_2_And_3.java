package eight.section;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECommerce_TC_2_And_3 extends BaseRealECommApp {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// findElements => size() works, if findElement => size() does't work
		// System.out.println(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size());
		// output : 2

		/*
		 * But this has many products in the list(it is showing only 2), since
		 * appium can detect only what is in the current screen view.
		 */
		/*
		 * Scrolling also not work because, it can hide what we want to view.
		 * So, we want to tell Appium to fully scroll until Product is displayed
		 * completely.
		 */

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))."
						+ "scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		// Important: Now how can we add this product to cart.
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

				break;
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// For Validation
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}

}
