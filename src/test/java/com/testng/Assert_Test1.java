package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Test1 {
	@Test(retryAnalyzer = Retry_Class.class)
	private void demo() {
		// Hard assert - validation

		String expected = "James";

		String actual = "Json";

		Assert.assertEquals(actual, expected);

		System.out.println("Data Validation");

	}
}
