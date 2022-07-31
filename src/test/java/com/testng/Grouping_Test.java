package com.testng;

import org.testng.annotations.Test;

public class Grouping_Test {
	@Test(groups = "music")
	private void spotify() {
		System.out.println("Spotify");
	}

	@Test(groups = "music")
	private void wynk() {
		System.out.println("Wynk");
	}

	@Test
	private void books() {
		System.out.println("books");
	}

	@Test(groups = "shopping")
	private void dressess() {
		System.out.println("dressess");
	}

	@Test(groups = "shopping")
	private void tshirt() {
		System.out.println("tshirt");
	}

}
