package com.runnerclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.baseclass.Base_Class;
import com.sdp.Page_Object_Manager;

public class Runner_Class extends  Base_Class{
	public static WebDriver driver=Base_Class.getBrowser("chrome");
	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	public static void main(String[] args) throws Throwable {
       driver = getUrl("https://adactinhotelapp.com/");
       waits("implicit", null);
       
       String user_Name = read_Data("C:\\Users\\ELCOT\\Desktop\\Name1.xlsx", "Sheet1", 1, 0);
       inputValueElement(pom.getInstatncelp().getUsername(), user_Name);
       
       String password = read_Data("C:\\Users\\ELCOT\\Desktop\\Name1.xlsx", "Sheet1", 1, 1);
       inputValueElement(pom.getInstatncelp().getPassword(), password);
       
       clickOnElement(pom.getInstatncelp().getLogin_Btn());
       dropDown(pom.getInstanceSearch().getLocation(), "selectByValue", "New York");
       dropDown(pom.getInstanceSearch().getHotels(), "selectbyvalue", "Hotel Sunshine");
       dropDown(pom.getInstanceSearch().getRoom_Type(), "selectbyvalue", "Super Deluxe");
       dropDown(pom.getInstanceSearch().getNumberOfRooms(), "selectbyvalue", "4");
       inputValueElement(pom.getInstanceSearch().getCheckInDate(), "09/07/2022");
       inputValueElement(pom.getInstanceSearch().getCheckOutDate(), "10/07/2022");
       dropDown(pom.getInstanceSearch().getAdultRoom(), "selectbyvalue", "2");
       dropDown(pom.getInstanceSearch().getChildRoom(), "selectbyvalue", "1");
       clickOnElement(pom.getInstanceSearch().getSearch());
       clickOnElement(pom.getInstanceSelect().getRadioButton());
       clickOnElement(pom.getInstanceSelect().getContinueBtn());
       inputValueElement(pom.getInstanceBook().getFirstName(), "william");
       inputValueElement(pom.getInstanceBook().getLastName(), "son");
       inputValueElement(pom.getInstanceBook().getAddress(), "no.12, second cross street, Atlanda");
       inputValueElement(pom.getInstanceBook().getCreditCadrd(), "1234567890427456");
       dropDown(pom.getInstanceBook().getCcType(), "selectbyvalue", "VISA");
       dropDown(pom.getInstanceBook().getCcExpYear(), "selectbyvisibletext", "2022");
       dropDown(pom.getInstanceBook().getCcExpMonth(), "selectbyvalue", "6");
       inputValueElement(pom.getInstanceBook().getCvvNumber(), "456");
       clickOnElement(pom.getInstanceBook().getBook_Now());
       clickOnElement(pom.getInstanceLogOut().getLogout());
       getScreenshotAs("C:\\Users\\ELCOT\\eclipse-workspace\\Maven_Project\\Screenshot\\adactin.png");
       
	}

}
