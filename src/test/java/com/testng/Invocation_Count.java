package com.testng;

import org.testng.annotations.Test;

public class Invocation_Count {
	@Test(priority = 2,invocationCount = 5)
	private void refresh() {
		System.out.println("refresh");
	}

	@Test(priority = 1)
	private void get_Url() {
		System.out.println("get Url");
	}

	@Test(priority = -1)
	private void browser_Launch() {
		System.out.println("Browser Launch");
	}

	@Test(priority = -2)
	private void set_Property() {
		System.out.println("set property");
	}

}
