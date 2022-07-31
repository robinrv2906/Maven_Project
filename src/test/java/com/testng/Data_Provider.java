package com.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	@Test(dataProvider = "data")
	private void credentials(String username, String password) {
		System.out.println("username is : " + username);
		System.out.println("password is : " + password);
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
			{"james","James@123"},
			{"Rahul","Rahul@456"},
			{"Rakesh","Rakesh@678"}
		};
	}

}
