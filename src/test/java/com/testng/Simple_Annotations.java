package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Simple_Annotations {
	@BeforeSuite
	private void set_Property() {
		System.out.println("set property");
	}

	@BeforeTest
	private void get_Browser() {
		System.out.println("get Browser");
	}

	@BeforeClass
	private void get_Url() {
		System.out.println("get Url");
	}

	@BeforeMethod
	private void signIn() {
		System.out.println("signIn");
	}

	@Test
	private void women() {
		System.out.println("women");
	}

	@Test
	private void dressess() {
		System.out.println("dressess");
	}

	@Test
	private void tshirt() {
		System.out.println("tshirt");
	}

	@AfterMethod
	private void signOff() {
		System.out.println("signoff");
	}

	@AfterClass
	private void homepage() {
		System.out.println("homepage");
	}

	@AfterTest
	private void close() {
		System.out.println("close");
	}

	@AfterSuite
	private void deletecookies() {
		System.out.println("delete cookies");
	}
}
