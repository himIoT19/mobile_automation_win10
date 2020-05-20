package pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependencies {

	AndroidDriver<AndroidElement> driver;

	public PreferenceDependencies(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/checkbox")
	private AndroidElement wifiCheckbox;

	/*
	 * When nothing is unique: class => android.widget.RelativeLayout TRICK:
	 * (android.widget.RelativeLayout).[2]
	 */
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]")
	private AndroidElement wifiSettings;

	public AndroidElement getWifiCheckbox() {
		return wifiCheckbox;
	}

	public AndroidElement getWifiSettings() {
		return wifiSettings;
	}

}
