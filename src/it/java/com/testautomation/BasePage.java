package com.testautomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	public static WebDriver driver;
	static HashMap<String, WebElement> dataObject = new HashMap<String, WebElement>();
	private FileInputStream inputStream;
	

	public BasePage() {
		loadProperties();
		
	}

	private void loadProperties() {
		Properties prop = System.getProperties();
		String propFileName = "config.properties";
		try {
			inputStream = new FileInputStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException ex) {
			System.out.println("property file '" + propFileName + "' not found in the classpath");
		}
	}

	public void SwitchtoFrameElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void SwitchtoDefault() {
		driver.switchTo().defaultContent();
	}

	public void navigate(String url) throws IOException {
		driver = initialiseWebDriver(System.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(System.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		driver.navigate().to(url);
	}

	public void clickButton(WebElement element) throws InterruptedException {
		element.click();
		Thread.sleep(3000);
	}
	
	public void selectDate(String how, String locator) throws InterruptedException {
		String locator1 = locator+tmrwDateMMDDYYYY()+"']";
		System.out.print("newlocator: " + locator1);
		findElement(how,locator1).click();
		Thread.sleep(3000);
	}

	public WebElement findElement(String how, String locator) {
		WebElement myElement = null;
		try {
			myElement = driver.findElement(getBy(how, locator));
		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}
		return myElement;
	}


	public void sendText(WebElement element, String text) throws InterruptedException {
		element.clear();
		Random rand = new Random();
		int n = rand.nextInt(10000) + 1;
		element.sendKeys(text+n);
	}
	
	public void sendTextEmail(WebElement element) throws InterruptedException {
		element.clear();
		Random rand = new Random();
		int n = rand.nextInt(10000) + 1;
		element.sendKeys("mail"+n+"@malinator.com");
	}
	
	public void sendTextNumber(WebElement element)throws InterruptedException {
	element.clear();
    Random generator = new Random();
    int num1 = generator.nextInt(600) + 100;
    int num2 = generator.nextInt(641) + 100;
    int num3 = generator.nextInt(8999) + 1000;      
    System.out.println("Here is a random generated phone number: " + num1 + "-" + num2 + "-" + num3);
	element.sendKeys(Integer.toString(num1)+num2+num3);
	}
	
	public void sendTmrwDate(WebElement element) throws InterruptedException {
		//element.clear();
		element.sendKeys(tmrwDateMMDDYYYY());
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}


	public WebDriver initialiseWebDriver(String browser) throws IOException {
		String osName = System.getProperty("os.name");
		System.out.println("OS name returned by the system is: " + osName);
		switch (browser) {

		case "chrome":
			try {
				if (osName.toLowerCase().contains("win")) 
					System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				 else 
					System.setProperty("webdriver.chrome.driver", "chromedriver");
				
			} catch (WebDriverException exception) {
				exception.printStackTrace();
				System.out.println("Found exception while setting chrome driver");
			}

			driver = new ChromeDriver();
			break;

		
		}
		return driver;
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}



	public Boolean selectDropDownText(String dropDownText, WebElement element) {
		Boolean flag = false;
		Select select = new Select(element);
		select.selectByVisibleText(dropDownText);
		flag = true;
		return flag;
	}


	public Boolean selectDropdownBasedOnValue(String how, String locator, String value) {
		Boolean flag = false;
		try {
			Select drpDwn = new Select(findElement(how, locator));
			drpDwn.selectByValue(value);
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean selectDropdownBasedOnIndex(String how, String locator, int index) {
		Boolean flag = false;
		try {
			Select drpDwn = new Select(findElement(how, locator));
			drpDwn.selectByIndex(index);
			flag = true;
		} catch (Exception e) {

		}
		return flag;
	}


	By getBy(String identifiedBy, String value) {
		By by = null;
		switch (identifiedBy) {
		case "id":
			by = By.id(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "cssSelector":
			by = By.cssSelector(value);
			break;
		default:
			by = By.id(value);
			break;
		}

		return by;
	}

	public static String tmrwDateMMDDYYYY() {
		//String pattern = "MM/dd/yyyy";
		String pattern = "EEEE, MMMM dd, yyyy";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//LocalDateTime now = LocalDateTime.now();
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 2);
		dt = c.getTime();
		String tmrwDate = simpleDateFormat.format(dt);
		return tmrwDate;
	}
}
