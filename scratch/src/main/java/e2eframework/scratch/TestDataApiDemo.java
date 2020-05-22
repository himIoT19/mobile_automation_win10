package e2eframework.scratch;

import org.testng.annotations.DataProvider;

public class TestDataApiDemo {


	@DataProvider(name = "InputData")
	public Object[][] getDataForEditField() {
		// 2 sets of data we are sending => "hello", "!@#$%"
		Object[][] obj = new Object[][] { { "hello" }, { "!@#$%" } };
	
		return obj;
	}
}
