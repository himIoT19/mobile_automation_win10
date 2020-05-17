package test.first;

//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {

	@Parameters({ "URL", "APIKey/username" })
	@Test
	public void DemoTwoPersonalLoan(String urlname, String key) {
		System.out.println("This is Test Case from different Class.");
		System.out.println(urlname);
		System.out.println(key);
	}

	@Test(groups = { "Smoke" })
	public void ploan() {
		System.out.println("Good");
	}

	@BeforeTest
	public void PrerequisitesExecuteFirst() {
		System.out.println("I will execute first of the Test Folder => Personal Loan");
	}

	@AfterTest
	public void PrererequisitesExecuteLast() {
		System.out.println("I will execute last of the Test Folder => Personal Loan");
		
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("After executing any method(s) inside the class => Test2");
	}

}
