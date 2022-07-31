package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	private void browser_Launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

	}

	@Test
	private void get_Url() throws Throwable {
		driver.get("https://www.facebook.com/login");
		Thread.sleep(2000);

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("robin@gmail.com");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.xpath("//input[@name='pass']"));
		password.sendKeys("Robin@123");
		Thread.sleep(2000);

		WebElement login_Btn = driver.findElement(By.name("login"));
		login_Btn.click();
		Thread.sleep(2000);
	}

	@AfterClass
	private void close_Browser() {
		driver.close();
	}
}
