package com.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Ignore_Test {
	@Test(enabled = false)
	private void women() {
		System.out.println("women");
	}

	@Test
	private void tshirt() {
		System.out.println("tshirt");
	}

	@Test
	private void dressess() {
		System.out.println("dressess");
	}
	@Ignore
	@Test
	private void men() {
		System.out.println("men");
	}
}
