package e2eframework.scratch;

import org.testng.annotations.DataProvider;

public class TestDataEcommerce {

	@DataProvider(name = "InputData")
	public Object[][] getDataForEditField() {
		// 2 sets of data we are sending => "hello", "!@#$%"
		Object[][] obj = new Object[][] { { "ADITI", "Bhutan" }, { "A!@#I", "Bhutan" }, { "AdItI", "Bhutan" },
				{ "1234", "Bhutan" }, { "AD92I", "Bhutan" } };

		return obj;
	}
}
