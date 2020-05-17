package test.first;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void Demo() {
		System.out.println("Hello TestNG !"); // automation
	}

	@AfterSuite
	public void AFSuite() {
		System.out.println("Hey! I am number one from LAST");
	}

	/*
	 * How to diffrentiate between one test and another test during execution ?
	 * Name of methods differentiate between Tests.
	 */
	@Test // 2nd testcase
	public void SecondTest() {
		System.out.println("Bye :)"); // automation
		/*
		 * This will fail the Test because it should be "true" but "false"
		 * provided.
		 */
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void AfterEvery() {
		System.out.println("...I am After Every Method in Test1 Class");
	}
}
