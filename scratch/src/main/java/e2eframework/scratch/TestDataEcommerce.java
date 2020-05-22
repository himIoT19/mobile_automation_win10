package e2eframework.scratch;

import org.testng.annotations.DataProvider;

public class TestDataEcommerce {

	@DataProvider(name = "InputData")
	public Object[][] getDataForEditField() {
		// 2 sets of data we are sending => "hello", "!@#$%"
		Object[][] obj = new Object[][] { { "ADITI", "India" }, { "A!@#I", "Aruba" }, { "AdItI", "Bahamas" },
				{ "1234", "Bhutan" }, { "AD92I", "Canada" } };

		return obj;
	}
}
