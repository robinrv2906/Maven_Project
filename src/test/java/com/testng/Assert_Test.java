package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Test {
//	@Test
//	private void demo() {
//		//Hard assert - validation
//		
//		String expected = "James";
//		
//		String actual = "Json";
//		
//		Assert.assertNotEquals(actual, expected);
//		
//		System.out.println("Data Validation");
//
//	}
	
	@Test
	private void demo() {
		//soft assert - verification
		
		String expected = "James";
		
		String actual = "Json";
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(actual, expected);
		
		soft.assertAll();
		
		System.out.println("Data Verification");

	}


}
