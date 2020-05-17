package nine.section;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridEcommerceApp_TC_OptimizedCode_1 extends BaseHybridRealEcommerceApp {

	@SuppressWarnings("rawtypes")
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

		// Mobile Gestures
		TouchAction t = new TouchAction(driver);
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		t.tap(tapOptions().withElement(element(checkbox))).perform();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * Automatically entering the web view context on session start. Since
		 * loading takes time and then we can get WebView context.
		 */
		Thread.sleep(7000);
		Set<String> contextNames = driver.getContextHandles();

		// prints out something like NATIVE_APP \n WEBVIEW_1
		for (String contextName : contextNames) {
			System.out.println(contextName);
		}
		/*
		 * Contexts : ([NATIVE_APP, WEBVIEW_com.androidsample.generalstore])
		 */
		
		// Set context to WEBVIEW_1 => WEBVIEW_com.androidsample.generalstore
		driver.context("WEBVIEW_com.androidsample.generalstore"); 
		
		// now do web automation from here
		driver.findElement(By.name("q")).sendKeys("India");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		// Set context back to NATIVE_APP
		driver.context("NATIVE_APP"); 


	}

}
