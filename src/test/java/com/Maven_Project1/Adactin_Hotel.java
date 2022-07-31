package com.Maven_Project1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adactin_Hotel {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Project\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1.user login
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("william1234");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("User@123");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement location = driver.findElement(By.id("location"));
		Select select = new Select(location);
		select.selectByIndex(1);
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select select1=new Select(hotels);
		select1.selectByValue("Hotel Sunshine");
		
		WebElement roomType = driver.findElement(By.id("room_type"));
		Select select2=new Select(roomType);
		select2.selectByVisibleText("Super Deluxe");
		
		WebElement roomNo = driver.findElement(By.id("room_nos"));
		Select select3= new Select(roomNo);
		select3.selectByVisibleText("1 - One");
		
		WebElement adultRoom = driver.findElement(By.id("adult_room"));
		Select select4=new Select(adultRoom);
		select4.selectByIndex(1);
		
		WebElement childremRoom = driver.findElement(By.id("child_room"));
		Select select5= new Select(childremRoom);
		select5.selectByVisibleText("2 - Two");
		
		WebElement search = driver.findElement(By.id("Submit"));
		search.click();
		
		WebElement selectHotel= driver.findElement(By.id("radiobutton_0"));
		selectHotel.click();
		
		WebElement confirmButton = driver.findElement(By.id("continue"));
		confirmButton.click();
		
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys("william");
		
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys("son");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("no.12, 2nd cross street, Atlanda");
		
		WebElement creditCard = driver.findElement(By.id("cc_num"));
		creditCard.sendKeys("1234567890427456");
		
		WebElement ccType = driver.findElement(By.id("cc_type"));
		Select select6= new Select(ccType);
		select6.selectByValue("VISA");
		
		WebElement ccExpMonth= driver.findElement(By.id("cc_exp_month"));
		Select select7= new Select(ccExpMonth);
		select7.selectByValue("6");
		
		WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
		Select select8= new Select(ccExpYear);
		select8.selectByVisibleText("2022");
		
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("1234567890427456");
		
		WebElement bookNow = driver.findElement(By.id("book_now"));
		bookNow.click();
		
		
		WebElement logOut = driver.findElement(By.id("logout"));
		logOut.click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Project\\ScreenShot\\adactin.png");
		FileUtils.copyFile( source, dest);
	}

}
