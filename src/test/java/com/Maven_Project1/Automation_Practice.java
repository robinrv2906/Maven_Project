package com.Maven_Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.Base_Class;

public class Automation_Practice extends Base_Class{
	
		public static WebDriver driver;    //null
		public static void main(String[] args) throws Throwable {
			driver = getBrowser("chrome");
					
			driver = getUrl("http://automationpractice.com/index.php/");
			
			WebElement signIn = driver.findElement(By.xpath("//a[@class=\"login\"]"));
			clickOnElement(signIn);
			Thread.sleep(3000);
			
			WebElement email = driver.findElement(By.id("email"));
			inputValueElement(email, "automationpracticeuser06@gmail.com");
			
			WebElement password = driver.findElement(By.id("passwd"));
			inputValueElement(password, "password@123");
			
			WebElement loginBtn = driver.findElement(By.id("SubmitLogin"));
			clickOnElement(loginBtn);
			 
			
			
			
		}

	

}
