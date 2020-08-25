package device.android.physical;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollMobileBrowser extends BaseChrome {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("emulator");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://cricbuzz.com"); // to hit URL in browser
		driver.findElementByXPath("//a[@href='#menu']").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());

		// we need JavascriptExecuter for MobileBrowser Scrolling
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,480)", "");
		Assert.assertTrue(
				driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));

	}

}
