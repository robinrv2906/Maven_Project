package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_Hotel {
	public static WebDriver driver;
	@FindBy(id = "first_name")
	private WebElement firstName;
	@FindBy(id = "last_name")
	private WebElement lastName;
	@FindBy(id = "address")
	private WebElement address;
	@FindBy(id = "cc_num")
	private WebElement creditCadrd;
	@FindBy(id = "cc_type")
	private WebElement ccType;
	@FindBy(id = "cc_exp_month")
	private WebElement ccExpMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement ccExpYear;
	@FindBy(id = "cc_cvv")
	private WebElement cvvNumber;
	@FindBy(id = "book_now")
	private WebElement book_Now;

	public Book_Hotel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditCadrd() {
		return creditCadrd;
	}
	public WebElement getCcType() {
		return ccType;
	}
	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}
	public WebElement getCcExpYear() {
		return ccExpYear;
	}
	public WebElement getCvvNumber() {
		return cvvNumber;
	}
	public WebElement getBook_Now() {
		return book_Now;
	}

}
