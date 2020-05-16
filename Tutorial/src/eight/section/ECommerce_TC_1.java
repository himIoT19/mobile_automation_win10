package eight.section;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECommerce_TC_1 extends BaseRealECommApp {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");

		// hide keyboard
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		// select spinner
		driver.findElementByClassName("android.widget.Spinner").click();

		// scroll down until India comes
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
		driver.findElementByXPath("//*[@text='India']").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}

}
