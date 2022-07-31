package com.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	public static WebDriver driver; // Null
	public static String value; // Null

	// 1.Browser Launch
	public static WebDriver getBrowser(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	// 2. Get Browser
	public static WebDriver getUrl(String url) {
		driver.get(url);
		return driver;
	}

	// 3. Click()
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	// 4. sendKeys()
	public static void inputValueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	// 5. close()
	public static WebDriver close() {
		driver.close();
		return driver;
	}

	// 6. Quit()
	public static WebDriver quit() {
		driver.quit();
		return driver;
	}

	// 7. navigateTo
	public static WebDriver navigateTo(String url) {
		driver.navigate().to(url);
		return driver;
	}

	// 8. navigateBack
	public static WebDriver navigateBack() {
		driver.navigate().back();
		return driver;
	}

	// 9.navigateForward
	public static WebDriver navigateForward() {
		driver.navigate().forward();
		return driver;
	}

	// 10. navigateRefresh
	public static WebDriver navigateRefresh() {
		driver.navigate().refresh();
		return driver;
	}

	// 11. Alert
	public static void alert(String type, String value) {
		Alert alert = driver.switchTo().alert();
		if (type.equalsIgnoreCase("ok")) {
			alert.accept();
		} else if (type.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		} else if (type.equalsIgnoreCase("sendkeys")) {
			alert.sendKeys(value);
			alert.accept();
		}
	}

	// 13. Frames
	public static void frame(String type, String name) {
		if (type.equalsIgnoreCase("indexOfFrame")) {
			int index = Integer.parseInt(name);
			driver.switchTo().frame(index);
		} else if (type.equalsIgnoreCase("nameOfFrame")) {
			driver.switchTo().frame(name);
		} else if (type.equalsIgnoreCase("exitOfFrame")) {
			driver.switchTo().defaultContent();
		}
	}

	// 14. DropDown
	public static void dropDown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("selectByValue")) {
			s.selectByValue(value);

		} else if (type.equalsIgnoreCase("selectByIndex")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		} else if (type.equalsIgnoreCase("selectByVisibleText")) {
			s.selectByVisibleText(value);
		}
	}

	// 15. is Enabled
	public static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("Element isEnabled: " + enabled);
	}

	// 16. is Displayed
	public static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println("Element isdisplayed: " + displayed);
	}

	// 17. is Selected
	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("Element isSelected: " + selected);
	}

	// 18. Get Attribute
	public static void getAttribute(WebElement element, String name) {
		String attribute = element.getAttribute(name);
		System.out.println(attribute);
	}

	// 19. Get Title
	public static WebDriver getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return driver;

	}

	// 20. Get currentUrl
	public static WebDriver getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return driver;
	}

	// 21. Get Text
	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// 22. is Multiple
	public static void isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// 23. Get all selected options
	public static void getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			String text = webElement.getText();
			System.out.println(text);
		}

	}

	// 24. Get first selected option
	public static void getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelected = s.getFirstSelectedOption();
		String text = firstSelected.getText();
		System.out.println(text);
	}

	// 25. Get Options
	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	// 26. Take Screen Shot
	public static void getScreenshotAs(String pathname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(pathname);
		FileUtils.copyFile(source, dest);
	}

	// 27. Robot
	public static void robot(String type, String key) throws Throwable {
		Robot robo = new Robot();
		if (type.equalsIgnoreCase("keypress")) {
			if (key.equalsIgnoreCase("a")) {
				robo.keyPress(KeyEvent.VK_A);
			} else if (key.equalsIgnoreCase("b")) {
				robo.keyPress(KeyEvent.VK_B);
			} else if (key.equalsIgnoreCase("c")) {
				robo.keyPress(KeyEvent.VK_C);
			} else if (key.equalsIgnoreCase("d")) {
				robo.keyPress(KeyEvent.VK_D);
			} else if (key.equalsIgnoreCase("e")) {
				robo.keyPress(KeyEvent.VK_E);
			} else if (key.equalsIgnoreCase("f")) {
				robo.keyPress(KeyEvent.VK_F);
			} else if (key.equalsIgnoreCase("g")) {
				robo.keyPress(KeyEvent.VK_G);
			} else if (key.equalsIgnoreCase("h")) {
				robo.keyPress(KeyEvent.VK_H);
			} else if (key.equalsIgnoreCase("i")) {
				robo.keyPress(KeyEvent.VK_I);
			} else if (key.equalsIgnoreCase("j")) {
				robo.keyPress(KeyEvent.VK_J);
			} else if (key.equalsIgnoreCase("k")) {
				robo.keyPress(KeyEvent.VK_K);
			} else if (key.equalsIgnoreCase("l")) {
				robo.keyPress(KeyEvent.VK_L);
			} else if (key.equalsIgnoreCase("m")) {
				robo.keyPress(KeyEvent.VK_M);
			} else if (key.equalsIgnoreCase("n")) {
				robo.keyPress(KeyEvent.VK_N);
			} else if (key.equalsIgnoreCase("o")) {
				robo.keyPress(KeyEvent.VK_O);
			} else if (key.equalsIgnoreCase("p")) {
				robo.keyPress(KeyEvent.VK_P);
			} else if (key.equalsIgnoreCase("q")) {
				robo.keyPress(KeyEvent.VK_Q);
			} else if (key.equalsIgnoreCase("r")) {
				robo.keyPress(KeyEvent.VK_R);
			} else if (key.equalsIgnoreCase("s")) {
				robo.keyPress(KeyEvent.VK_S);
			} else if (key.equalsIgnoreCase("t")) {
				robo.keyPress(KeyEvent.VK_T);
			} else if (key.equalsIgnoreCase("u")) {
				robo.keyPress(KeyEvent.VK_U);
			} else if (key.equalsIgnoreCase("v")) {
				robo.keyPress(KeyEvent.VK_V);
			} else if (key.equalsIgnoreCase("w")) {
				robo.keyPress(KeyEvent.VK_W);
			} else if (key.equalsIgnoreCase("x")) {
				robo.keyPress(KeyEvent.VK_X);
			} else if (key.equalsIgnoreCase("y")) {
				robo.keyPress(KeyEvent.VK_Y);
			} else if (key.equalsIgnoreCase("z")) {
				robo.keyPress(KeyEvent.VK_Z);
			} else if (key.equalsIgnoreCase("0")) {
				robo.keyPress(KeyEvent.VK_0);
			} else if (key.equalsIgnoreCase("1")) {
				robo.keyPress(KeyEvent.VK_1);
			} else if (key.equalsIgnoreCase("2")) {
				robo.keyPress(KeyEvent.VK_2);
			} else if (key.equalsIgnoreCase("3")) {
				robo.keyPress(KeyEvent.VK_3);
			} else if (key.equalsIgnoreCase("4")) {
				robo.keyPress(KeyEvent.VK_4);
			} else if (key.equalsIgnoreCase("5")) {
				robo.keyPress(KeyEvent.VK_5);
			} else if (key.equalsIgnoreCase("6")) {
				robo.keyPress(KeyEvent.VK_6);
			} else if (key.equalsIgnoreCase("7")) {
				robo.keyPress(KeyEvent.VK_7);
			} else if (key.equalsIgnoreCase("8")) {
				robo.keyPress(KeyEvent.VK_8);
			} else if (key.equalsIgnoreCase("9")) {
				robo.keyPress(KeyEvent.VK_9);
			} else if (key.equalsIgnoreCase("enter")) {
				robo.keyPress(KeyEvent.VK_ENTER);
			} else if (key.equalsIgnoreCase("backspace")) {
				robo.keyPress(KeyEvent.VK_BACK_SPACE);
			} else if (key.equalsIgnoreCase("delete")) {
				robo.keyPress(KeyEvent.VK_DELETE);
			} else if (key.equalsIgnoreCase("prtsc")) {
				robo.keyPress(KeyEvent.VK_PRINTSCREEN);
			} else if (key.equalsIgnoreCase("esc")) {
				robo.keyPress(KeyEvent.VK_ESCAPE);
			} else if (key.equalsIgnoreCase("shift")) {
				robo.keyPress(KeyEvent.VK_SHIFT);
			} else if (key.equalsIgnoreCase("up")) {
				robo.keyPress(KeyEvent.VK_UP);
			} else if (key.equalsIgnoreCase("down")) {
				robo.keyPress(KeyEvent.VK_DOWN);
			} else if (key.equalsIgnoreCase("left")) {
				robo.keyPress(KeyEvent.VK_LEFT);
			} else if (key.equalsIgnoreCase("right")) {
				robo.keyPress(KeyEvent.VK_RIGHT);
			} else if (key.equalsIgnoreCase("tab")) {
				robo.keyPress(KeyEvent.VK_TAB);
			} else if (key.equalsIgnoreCase("capslock")) {
				robo.keyPress(KeyEvent.VK_CAPS_LOCK);
			} else if (key.equalsIgnoreCase("ctrl")) {
				robo.keyPress(KeyEvent.VK_CONTROL);
			} else if (key.equalsIgnoreCase("f1")) {
				robo.keyPress(KeyEvent.VK_F1);
			} else if (key.equalsIgnoreCase("f2")) {
				robo.keyPress(KeyEvent.VK_F2);
			} else if (key.equalsIgnoreCase("f3")) {
				robo.keyPress(KeyEvent.VK_F3);
			} else if (key.equalsIgnoreCase("f4")) {
				robo.keyPress(KeyEvent.VK_F4);
			} else if (key.equalsIgnoreCase("f5")) {
				robo.keyPress(KeyEvent.VK_F5);
			} else if (key.equalsIgnoreCase("f6")) {
				robo.keyPress(KeyEvent.VK_F6);
			} else if (key.equalsIgnoreCase("f7")) {
				robo.keyPress(KeyEvent.VK_F7);
			} else if (key.equalsIgnoreCase("f8")) {
				robo.keyPress(KeyEvent.VK_F8);
			} else if (key.equalsIgnoreCase("f9")) {
				robo.keyPress(KeyEvent.VK_F9);
			} else if (key.equalsIgnoreCase("f10")) {
				robo.keyPress(KeyEvent.VK_F10);
			} else if (key.equalsIgnoreCase("f11")) {
				robo.keyPress(KeyEvent.VK_F11);
			} else if (key.equalsIgnoreCase("f12")) {
				robo.keyPress(KeyEvent.VK_F12);
			} else if (key.equalsIgnoreCase("f13")) {
				robo.keyPress(KeyEvent.VK_F13);
			} else if (key.equalsIgnoreCase("f14")) {
				robo.keyPress(KeyEvent.VK_F14);
			} else if (key.equalsIgnoreCase("f15")) {
				robo.keyPress(KeyEvent.VK_F15);
			} else if (key.equalsIgnoreCase("f16")) {
				robo.keyPress(KeyEvent.VK_F16);
			} else if (key.equalsIgnoreCase("f17")) {
				robo.keyPress(KeyEvent.VK_F17);
			} else if (key.equalsIgnoreCase("f18")) {
				robo.keyPress(KeyEvent.VK_F18);
			} else if (key.equalsIgnoreCase("f19")) {
				robo.keyPress(KeyEvent.VK_F19);
			} else if (key.equalsIgnoreCase("f20")) {
				robo.keyPress(KeyEvent.VK_F20);
			} else if (key.equalsIgnoreCase("f21")) {
				robo.keyPress(KeyEvent.VK_F21);
			} else if (key.equalsIgnoreCase("f22")) {
				robo.keyPress(KeyEvent.VK_F22);
			} else if (key.equalsIgnoreCase("f23")) {
				robo.keyPress(KeyEvent.VK_F23);
			} else if (key.equalsIgnoreCase("f24")) {
				robo.keyPress(KeyEvent.VK_F24);
			} else if (key.equalsIgnoreCase("space")) {
				robo.keyPress(KeyEvent.VK_SPACE);
			} else if (key.equalsIgnoreCase("window")) {
				robo.keyPress(KeyEvent.VK_WINDOWS);
			} else if (key.equalsIgnoreCase("alt")) {
				robo.keyPress(KeyEvent.VK_ALT);
			} else if (key.equalsIgnoreCase("=")) {
				robo.keyPress(KeyEvent.VK_EQUALS);
			} else if (key.equalsIgnoreCase("-")) {
				robo.keyPress(KeyEvent.VK_SUBTRACT);
			} else if (key.equalsIgnoreCase("backslash")) {
				robo.keyPress(KeyEvent.VK_BACK_SLASH);
			} else if (key.equalsIgnoreCase("/")) {
				robo.keyPress(KeyEvent.VK_SLASH);
			} else if (key.equalsIgnoreCase(",")) {
				robo.keyPress(KeyEvent.VK_COMMA);
			} else if (key.equalsIgnoreCase(".")) {
				robo.keyPress(KeyEvent.VK_STOP);
			} else if (key.equalsIgnoreCase(";")) {
				robo.keyPress(KeyEvent.VK_SEMICOLON);
			} else if (key.equalsIgnoreCase("'")) {
				robo.keyPress(KeyEvent.VK_QUOTE);
			}

			else if (key.equalsIgnoreCase("[")) {
				robo.keyPress(KeyEvent.VK_BRACELEFT);
			} else if (key.equalsIgnoreCase("]")) {
				robo.keyPress(KeyEvent.VK_BRACERIGHT);
			}
		} else if (type.equalsIgnoreCase("keyrelease")) {
			if (key.equalsIgnoreCase("a")) {
				robo.keyRelease(KeyEvent.VK_A);
			} else if (key.equalsIgnoreCase("b")) {
				robo.keyRelease(KeyEvent.VK_B);
			} else if (key.equalsIgnoreCase("c")) {
				robo.keyRelease(KeyEvent.VK_C);
			} else if (key.equalsIgnoreCase("d")) {
				robo.keyRelease(KeyEvent.VK_D);
			} else if (key.equalsIgnoreCase("e")) {
				robo.keyRelease(KeyEvent.VK_E);
			} else if (key.equalsIgnoreCase("f")) {
				robo.keyRelease(KeyEvent.VK_F);
			} else if (key.equalsIgnoreCase("g")) {
				robo.keyRelease(KeyEvent.VK_G);
			} else if (key.equalsIgnoreCase("h")) {
				robo.keyRelease(KeyEvent.VK_H);
			} else if (key.equalsIgnoreCase("i")) {
				robo.keyRelease(KeyEvent.VK_I);
			} else if (key.equalsIgnoreCase("j")) {
				robo.keyRelease(KeyEvent.VK_J);
			} else if (key.equalsIgnoreCase("k")) {
				robo.keyRelease(KeyEvent.VK_K);
			} else if (key.equalsIgnoreCase("l")) {
				robo.keyRelease(KeyEvent.VK_L);
			} else if (key.equalsIgnoreCase("m")) {
				robo.keyRelease(KeyEvent.VK_M);
			} else if (key.equalsIgnoreCase("n")) {
				robo.keyRelease(KeyEvent.VK_N);
			} else if (key.equalsIgnoreCase("o")) {
				robo.keyRelease(KeyEvent.VK_O);
			} else if (key.equalsIgnoreCase("p")) {
				robo.keyRelease(KeyEvent.VK_P);
			} else if (key.equalsIgnoreCase("q")) {
				robo.keyRelease(KeyEvent.VK_Q);
			} else if (key.equalsIgnoreCase("r")) {
				robo.keyRelease(KeyEvent.VK_R);
			} else if (key.equalsIgnoreCase("s")) {
				robo.keyRelease(KeyEvent.VK_S);
			} else if (key.equalsIgnoreCase("t")) {
				robo.keyRelease(KeyEvent.VK_T);
			} else if (key.equalsIgnoreCase("u")) {
				robo.keyRelease(KeyEvent.VK_U);
			} else if (key.equalsIgnoreCase("v")) {
				robo.keyRelease(KeyEvent.VK_V);
			} else if (key.equalsIgnoreCase("w")) {
				robo.keyRelease(KeyEvent.VK_W);
			} else if (key.equalsIgnoreCase("x")) {
				robo.keyRelease(KeyEvent.VK_X);
			} else if (key.equalsIgnoreCase("y")) {
				robo.keyRelease(KeyEvent.VK_Y);
			} else if (key.equalsIgnoreCase("z")) {
				robo.keyRelease(KeyEvent.VK_Z);
			} else if (key.equalsIgnoreCase("0")) {
				robo.keyRelease(KeyEvent.VK_0);
			} else if (key.equalsIgnoreCase("1")) {
				robo.keyRelease(KeyEvent.VK_1);
			} else if (key.equalsIgnoreCase("2")) {
				robo.keyRelease(KeyEvent.VK_2);
			} else if (key.equalsIgnoreCase("3")) {
				robo.keyRelease(KeyEvent.VK_3);
			} else if (key.equalsIgnoreCase("4")) {
				robo.keyRelease(KeyEvent.VK_4);
			} else if (key.equalsIgnoreCase("5")) {
				robo.keyRelease(KeyEvent.VK_5);
			} else if (key.equalsIgnoreCase("6")) {
				robo.keyRelease(KeyEvent.VK_6);
			} else if (key.equalsIgnoreCase("7")) {
				robo.keyRelease(KeyEvent.VK_7);
			} else if (key.equalsIgnoreCase("8")) {
				robo.keyRelease(KeyEvent.VK_8);
			} else if (key.equalsIgnoreCase("9")) {
				robo.keyRelease(KeyEvent.VK_9);
			} else if (key.equalsIgnoreCase("enter")) {
				robo.keyRelease(KeyEvent.VK_ENTER);
			} else if (key.equalsIgnoreCase("backspace")) {
				robo.keyRelease(KeyEvent.VK_BACK_SPACE);
			} else if (key.equalsIgnoreCase("delete")) {
				robo.keyRelease(KeyEvent.VK_DELETE);
			} else if (key.equalsIgnoreCase("prtsc")) {
				robo.keyRelease(KeyEvent.VK_PRINTSCREEN);
			} else if (key.equalsIgnoreCase("esc")) {
				robo.keyRelease(KeyEvent.VK_ESCAPE);
			} else if (key.equalsIgnoreCase("shift")) {
				robo.keyRelease(KeyEvent.VK_SHIFT);
			} else if (key.equalsIgnoreCase("up")) {
				robo.keyRelease(KeyEvent.VK_UP);
			} else if (key.equalsIgnoreCase("down")) {
				robo.keyRelease(KeyEvent.VK_DOWN);
			} else if (key.equalsIgnoreCase("left")) {
				robo.keyRelease(KeyEvent.VK_LEFT);
			} else if (key.equalsIgnoreCase("right")) {
				robo.keyRelease(KeyEvent.VK_RIGHT);
			} else if (key.equalsIgnoreCase("tab")) {
				robo.keyRelease(KeyEvent.VK_TAB);
			} else if (key.equalsIgnoreCase("capslock")) {
				robo.keyRelease(KeyEvent.VK_CAPS_LOCK);
			} else if (key.equalsIgnoreCase("ctrl")) {
				robo.keyRelease(KeyEvent.VK_CONTROL);
			} else if (key.equalsIgnoreCase("f1")) {
				robo.keyRelease(KeyEvent.VK_F1);
			} else if (key.equalsIgnoreCase("f2")) {
				robo.keyRelease(KeyEvent.VK_F2);
			} else if (key.equalsIgnoreCase("f3")) {
				robo.keyRelease(KeyEvent.VK_F3);
			} else if (key.equalsIgnoreCase("f4")) {
				robo.keyRelease(KeyEvent.VK_F4);
			} else if (key.equalsIgnoreCase("f5")) {
				robo.keyRelease(KeyEvent.VK_F5);
			} else if (key.equalsIgnoreCase("f6")) {
				robo.keyRelease(KeyEvent.VK_F6);
			} else if (key.equalsIgnoreCase("f7")) {
				robo.keyRelease(KeyEvent.VK_F7);
			} else if (key.equalsIgnoreCase("f8")) {
				robo.keyRelease(KeyEvent.VK_F8);
			} else if (key.equalsIgnoreCase("f9")) {
				robo.keyRelease(KeyEvent.VK_F9);
			} else if (key.equalsIgnoreCase("f10")) {
				robo.keyRelease(KeyEvent.VK_F10);
			} else if (key.equalsIgnoreCase("f11")) {
				robo.keyRelease(KeyEvent.VK_F11);
			} else if (key.equalsIgnoreCase("f12")) {
				robo.keyRelease(KeyEvent.VK_F12);
			} else if (key.equalsIgnoreCase("f13")) {
				robo.keyRelease(KeyEvent.VK_F13);
			} else if (key.equalsIgnoreCase("f14")) {
				robo.keyRelease(KeyEvent.VK_F14);
			} else if (key.equalsIgnoreCase("f15")) {
				robo.keyRelease(KeyEvent.VK_F15);
			} else if (key.equalsIgnoreCase("f16")) {
				robo.keyRelease(KeyEvent.VK_F16);
			} else if (key.equalsIgnoreCase("f17")) {
				robo.keyRelease(KeyEvent.VK_F17);
			} else if (key.equalsIgnoreCase("f18")) {
				robo.keyRelease(KeyEvent.VK_F18);
			} else if (key.equalsIgnoreCase("f19")) {
				robo.keyRelease(KeyEvent.VK_F19);
			} else if (key.equalsIgnoreCase("f20")) {
				robo.keyRelease(KeyEvent.VK_F20);
			} else if (key.equalsIgnoreCase("f21")) {
				robo.keyRelease(KeyEvent.VK_F21);
			} else if (key.equalsIgnoreCase("f22")) {
				robo.keyRelease(KeyEvent.VK_F22);
			} else if (key.equalsIgnoreCase("f23")) {
				robo.keyRelease(KeyEvent.VK_F23);
			} else if (key.equalsIgnoreCase("f24")) {
				robo.keyRelease(KeyEvent.VK_F24);
			} else if (key.equalsIgnoreCase("space")) {
				robo.keyRelease(KeyEvent.VK_SPACE);
			} else if (key.equalsIgnoreCase("window")) {
				robo.keyRelease(KeyEvent.VK_WINDOWS);
			} else if (key.equalsIgnoreCase("alt")) {
				robo.keyRelease(KeyEvent.VK_ALT);
			} else if (key.equalsIgnoreCase("=")) {
				robo.keyRelease(KeyEvent.VK_EQUALS);
			} else if (key.equalsIgnoreCase("-")) {
				robo.keyRelease(KeyEvent.VK_SUBTRACT);
			} else if (key.equalsIgnoreCase("backslash")) {
				robo.keyRelease(KeyEvent.VK_BACK_SLASH);
			} else if (key.equalsIgnoreCase("/")) {
				robo.keyRelease(KeyEvent.VK_SLASH);
			} else if (key.equalsIgnoreCase(",")) {
				robo.keyRelease(KeyEvent.VK_COMMA);
			} else if (key.equalsIgnoreCase(".")) {
				robo.keyRelease(KeyEvent.VK_STOP);
			} else if (key.equalsIgnoreCase(";")) {
				robo.keyRelease(KeyEvent.VK_SEMICOLON);
			} else if (key.equalsIgnoreCase("'")) {
				robo.keyRelease(KeyEvent.VK_QUOTE);
			}

			else if (key.equalsIgnoreCase("[")) {
				robo.keyRelease(KeyEvent.VK_BRACELEFT);
			} else if (key.equalsIgnoreCase("]")) {
				robo.keyRelease(KeyEvent.VK_BRACERIGHT);
			}
		}
	}

	// 28. window Handles
	public static WebDriver windowHandles(String type, String value) {

		String parent = driver.getWindowHandle();
		Set<String> allwind = driver.getWindowHandles();
		String actual_title = value;

		if (type.equalsIgnoreCase("getSizeofWindow")) {
			int size = driver.getWindowHandles().size();
			System.out.println("no of windows: " + size);
		} else if (type.equalsIgnoreCase("parentWindowName")) {

			System.out.println(parent);
		} else if (type.equalsIgnoreCase("allWindowName")) {

			for (String cp : allwind) {
				String title = driver.switchTo().window(cp).getTitle();
				System.out.println(title);
			}
		} else if (type.equalsIgnoreCase("selectwindow")) {
			for (String cp : allwind) {
				if (driver.switchTo().window(cp).getTitle().equals(actual_title)) {
					break;
				}

			}
		} else if (type.equalsIgnoreCase("closeAllwindowExceptParent")) {
			for (String cp : allwind) {
				if (!cp.equals(parent)) {
					driver.switchTo().window(cp);
					driver.close();
				}
			}
		}
		return driver;

	}

	// 12.actions
	public static void actions(String type, WebElement from, WebElement to) {
		Actions action = new Actions(driver);
		if (type.equalsIgnoreCase("click")) {
			action.click(from).build().perform();
		} else if (type.equalsIgnoreCase("rightclick")) {
			action.contextClick(from).build().perform();
		} else if (type.equalsIgnoreCase("doubleclick")) {
			action.doubleClick(from).build().perform();
		} else if (type.equalsIgnoreCase("moveToElement")) {
			action.moveToElement(from).build().perform();
		} else if (type.equalsIgnoreCase("dragAndDrop")) {
			action.dragAndDrop(from, to).build().perform();
			// action.clickAndHold(from).moveToElement(to).release(to).build().perform();
		} else if (type.equalsIgnoreCase("clickAndHold")) {
			action.clickAndHold(from).build().perform();
		} else if (type.equalsIgnoreCase("release")) {
			action.release(from).build().perform();
		}
	}

	// 29. checkBox
	public static void checkBox(String type, WebElement element) {
		if (type.equalsIgnoreCase("selectcheckbbox")) {
			element.click();
		} else if (type.equalsIgnoreCase("checkboxisSelected")) {
			boolean selected = element.isSelected();
			System.out.println(selected);
		} else if (type.equalsIgnoreCase("deselectOnlyChecked")) {
			if (element.isSelected()) {
				element.click();
			}
		} else if (type.equalsIgnoreCase("selectAllcheckbox")) {
			if (element.isSelected()) {
			} else {
				element.click();
			}
		}
	}

	// 30. waits
	public static void waits(String type, WebElement element) {
		if (type.equalsIgnoreCase("implicit")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (type.equalsIgnoreCase("explicit")) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

//31.  ScrollUp And ScrollDown
	public static void scroll(String type, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (type.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,500);");
		} else if (type.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,-500);");
		} else if (type.equalsIgnoreCase("fromelement")) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} else if (type.equalsIgnoreCase("end")) {
			js.executeScript("window.scroll(0,document.body.scrollHeight)", "");
		} else if (type.equalsIgnoreCase("top")) {
			js.executeScript("window.scroll(0,0)", "");
		} else if (type.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click();", element);
		}
	}

	// 32.Radio Button
	public static void radioButton(String type, WebElement element) {
		if (type.equalsIgnoreCase("selectradiobutton")) {
			element.click();
		} else if (type.equalsIgnoreCase("findDefaultRadiobutton")) {
			boolean selected = element.isSelected();
			System.out.println(selected);
		}
	}

	// 33.clear
	public static void clear(WebElement element) {
		element.clear();
	}

	// Read_Data
	public static  String read_Data(String path, String sheet_Name, int row_Index, int cell_Index) throws IOException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheet_Name);
		Row row = sheet.getRow(row_Index);
		Cell cell = row.getCell(cell_Index);
		CellType cellType = cell.getCellType();
		if (cellType.equals(CellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			value = String.valueOf(stringCellValue);

		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data = (int) numericCellValue;
			value = String.valueOf(data);
		}
		wb.close();
		return value;
	}

}
