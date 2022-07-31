package com.testng;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel_Test {
	@Test
	private void chrome_Launch1() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Project\\Driver\\chromedriver.exe");

		WebDriver driver1 = new ChromeDriver();

		Dimension d = new Dimension(500, 500);
		driver1.manage().window().setSize(d);
		
		Point p =new Point(0, 100);
		driver1.manage().window().setPosition(p);

		driver1.get("https://www.google.co.in/");
		driver1.close();
	}

	@Test
	private void chrome_Launch2() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Project\\Driver\\chromedriver.exe");

		WebDriver driver2 = new ChromeDriver();

		Dimension d = new Dimension(500, 500);
		driver2.manage().window().setSize(d);
		
		Point p =new Point(750, 100);
		driver2.manage().window().setPosition(p);

		driver2.get("https://www.facebook.com/");
		driver2.close();
	}

}
