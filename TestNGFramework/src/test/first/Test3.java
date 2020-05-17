package test.first;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {

	@Test
	public void DependentOnOne() {
		System.out.println("U will execute after me my dependent one");
	}

	@Test(dataProvider = "getData")
	public void DependentOnOneThing(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before executing any method(s) inside the class => Test3");
	}

	@Test(groups = { "Smoke" })
	public void WebLoginCarLoan() {
		// selenium
		System.out.println("Web login car.");
	}

	@Parameters({ "URL" })
	@Test
	public void MobileLoginCarLoan(String urlName) {
		// appium
		System.out.println("Mobile login car.");
		System.out.println("My URL => " + urlName);

	}

	/* if a bug already known in this test we use enabled */
	@Test(enabled = false)
	public void MobileSignInCarLoan() {
		// appium
		System.out.println("Mobile SIGNIN");

	}

	@BeforeSuite
	public void BFSuite() {
		System.out.println("Hey! I am number one from START");
	}

	/* Wait for 4 sec to get response if server slow */
	@Test(timeOut = 4000)
	public void MobileSignOutCarLoan() {
		// appium
		System.out.println("Mobile SIGNOUT");

	}

	@BeforeMethod
	public void BeforeEvery() {
		System.out.println("I am Before Every Method...Test3 Class");
	}

	/* Single/multiple method(Test/s) dependent */
	@Test(dependsOnMethods = { "DependentOnOne", "DependentOnTwo" })
	public void LoginAPICarLoan() {
		// REST API automation
		System.out.println("API login car.");

	}

	@Test
	public void DependentOnTwo() {
		System.out.println("U will execute after me my dependent two");
	}

	@DataProvider
	public Object[][] getData() {
		/*
		 * 1. Combination username password -> good credit history in past years
		 * 2. Combination username password -> no credit history in past years
		 * 3. Combination username password -> fraud credit history in past
		 */

		// Multidimensional Object Array
		Object[][] data = new Object[3][2]; // noOfCombinations->row(3)
											// dataProvided->columns(2)
		// 1st Set
		data[0][0] = "firstSetUserName"; // firstRow
		data[0][1] = "firstpassword"; // FirstRow
		/*
		 * Columns in the row are nothing but values for that combination(row)
		 */

		// 2nd Set
		data[1][0] = "secondSetUserName";
		data[1][1] = "secondpassword";

		// 3rd Set
		data[2][0] = "thirdSetUserName";
		data[2][1] = "thirdpassword";

		return data;
	}
}
