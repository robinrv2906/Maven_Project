package com.testng;

import org.testng.annotations.Test;

public class TimeOut_test {
	@Test(timeOut = 7000)
	private void logIn() throws Throwable {
		System.out.println("set property");
		
		Thread.sleep(3000);

		System.out.println("Browser Launch");

		System.out.println("Get URL");
		
		Thread.sleep(2000);
		System.out.println("to pass the credentials");
		
		Thread.sleep(1500);
		System.out.println("Click LogIn");
	}
}
