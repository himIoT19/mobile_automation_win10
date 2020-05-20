package pageobjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FrameLayout {

	AndroidDriver<AndroidElement> driver;

	public FrameLayout(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(className = "android.widget.EditText")
	private AndroidElement editText;

	@AndroidFindBy(className = "android.widget.Button")
	private List<AndroidElement> okButton;

	@AndroidFindBy(className = "android.widget.Button")
	private List<AndroidElement> cancelButton;

	public AndroidElement getEditText() {
		return editText;
	}

	public List<AndroidElement> getOkButton() {
		return okButton;
	}

	public List<AndroidElement> getCancelButton() {
		return cancelButton;
	}

}
