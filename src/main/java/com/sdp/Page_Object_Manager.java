package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.Book_Hotel;
import com.pom.LogOut;
import com.pom.Login_Page;
import com.pom.Search_Hotel;
import com.pom.Select_Hotel;

public class Page_Object_Manager {
	public static WebDriver driver;
	private Login_Page lp;
	private Search_Hotel sh;
	private Select_Hotel sh1;
	private Book_Hotel bh;
	private LogOut log;
		
	public Page_Object_Manager(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	public Login_Page getInstatncelp() {
		lp = new Login_Page(driver);
		return lp;
	}
	public Search_Hotel getInstanceSearch() {
		sh = new Search_Hotel(driver);
		return sh;
	}
	public Select_Hotel getInstanceSelect() {
		sh1=new Select_Hotel(driver);
		return sh1;
	}
	
	public Book_Hotel getInstanceBook() {
		bh=new Book_Hotel(driver);
		return bh;
	}
	public LogOut getInstanceLogOut() {
		log=new LogOut(driver);
		return log;

	}


}
