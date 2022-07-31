package com.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterized_Test{
	@Parameters({"username" , "password"})
	@Test
	private void credentials(@Optional("Json")String username, @Optional("Json@123")String password) {
		//inputValueElement(pom.getInstatncelp().getUsername(), username);

		System.out.println("Username is : " + username);
		System.out.println("password is : " + password);

	}
}
