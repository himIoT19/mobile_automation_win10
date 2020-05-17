package test.first;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {

	@Parameters({ "URL" })
	@Test
	public void WebLoginHomeLoan(String urlName) {
		// selenium
		System.out.println("Web login home personal loan.");
		System.out.println(urlName);
	}

	@Test(groups = { "Smoke" })
	public void MobileLoginHomeLoan() {
		// appium
		System.out.println("Mobile login home");

	}

	@Test
	public void MobileSignInHomeLoan() {
		// appium
		System.out.println("Mobile SIGNIN");

	}

	@Test
	public void MobileSignOutHomeLoan() {
		// appium
		System.out.println("Mobile SIGNOUT");

	}

	@Test
	public void LoginAPIHomeLoan() {
		// REST API automation
		System.out.println("API login home.");

	}
}
