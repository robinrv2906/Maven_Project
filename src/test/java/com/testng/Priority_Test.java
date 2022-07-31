package com.testng;

import org.testng.annotations.Test;

public class Priority_Test {
	@Test(priority = -5)
	private void set_Property() {
		System.out.println("set property");
	}

	@Test(priority = -1)
	private void get_Browser() {
		System.out.println("get Browser");
	}

	@Test
	private void get_Url() {
		System.out.println("get Url");
	}

	@Test(priority = 1)
	private void signIn() {
		System.out.println("signIn");
	}

	@Test(priority = 5)
	private void dressess() {
		System.out.println("dressess");
	}
}
