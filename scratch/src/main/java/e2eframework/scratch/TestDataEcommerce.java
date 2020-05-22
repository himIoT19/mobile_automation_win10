package e2eframework.scratch;

import org.testng.annotations.DataProvider;

public class TestDataEcommerce {


	@DataProvider(name = "InputData")
	public Object[][] getDataForEditField() {
		// 2 sets of data we are sending => "hello", "!@#$%"
		Object[][] obj = new Object[][] { { "ADITI" }, { "A!@#I" }, {"AdItI"}, {"1234"}, {"AD92I"} };
	
		return obj;
	}
}
