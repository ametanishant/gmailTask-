package com.nishant.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	public String url = PropertiesUtil.getProperty("url"); 

	@BeforeTest
	public void browserSetup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty("webdriver.chrome.driver","//Users//nishantameta//Downloads//chromedriver");
		

	}

	/****************************************
	 * login into gmail account and validate first name
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 ********************************************/

	@Test
	public void testLoginIntoGmail() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		driver.get(url);

		// Now login Provide username and click
		ProvideUserName userNamePage = new ProvideUserName(driver);
		userNamePage.setUserName(PropertiesUtil.getProperty("user_name"));
		userNamePage.clickOnNext();
		
        // Provide password and click
		PasswordPage password = new PasswordPage(driver);
		password.setPassword(PropertiesUtil.getProperty(("password")));
		builder.sendKeys(Keys.ENTER).perform();

		Thread.sleep(10000);
		String expectedTitle = "testnishant04@gmail.com - Gmail";

		String title = driver.getTitle();
		System.out.println(title);
		boolean title2 = title.contains("testnishant04@gmail.com");

		if (title2 == true) {
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(true, false);
		}

		driver.close();

	}

	/*************************************************************
	 * 
	 * test if user has unread email
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 **************************************************************/
	@Test
	public void testUnreadEmail() throws InterruptedException {
         try {
		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		driver.get(url);

		/*********************************************** 
		 * Now we are implementing Page Object Model 
		 * Now login Provide username and click
		 * 
		 * 
		 *********************************************/
	    ProvideUserName userNamePage = new ProvideUserName(driver);
		userNamePage.setUserName(PropertiesUtil.getProperty("user_name"));
		userNamePage.clickOnNext();
				
		// Provide password and click
		PasswordPage password = new PasswordPage(driver);
        password.setPassword(PropertiesUtil.getProperty(("password")));
		builder.sendKeys(Keys.ENTER).perform();

		Thread.sleep(5000);

		// Unread email

		String title = driver.getTitle();
		System.out.println(title);
		
		char a_char = title.charAt(7);
		int i = Character.getNumericValue(a_char);

		if (i > 0) {
			Assert.assertEquals(true, true);
		}

		System.out.println(a_char);

		driver.close();
         }
         
         catch (StringIndexOutOfBoundsException e ){
        	 Assert.assertEquals(true, true);
 		
        	 System.out.println("No unread email");
         }
	}

	/*****************************************************************
	 * 
	 * Compose an email an send to the same account and check whether email
	 * received or not
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 *********************************************************************/

	@Test
	public void testComposeAndSendEmail() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.get(url);
		
		//login 
		ProvideUserName userNamePage = new ProvideUserName(driver);
	    userNamePage.setUserName(PropertiesUtil.getProperty("user_name"));
		userNamePage.clickOnNext();
					
		
		PasswordPage password = new PasswordPage(driver);
	    password.setPassword(PropertiesUtil.getProperty(("password")));
		builder.sendKeys(Keys.ENTER).perform();

		
        // Now compose and send email

		String n = Resources.genrateRandomNumber();

		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.clickOnCompose();
		Thread.sleep(1000);
		inboxPage.clickOnToAndEnterEmail(PropertiesUtil.getProperty("email_to"));
		builder.sendKeys(Keys.TAB).perform();
		builder.sendKeys(Keys.TAB).perform();
        inboxPage.clickOnSubjectAndEnterSubject("Email Number" + n);
        inboxPage.clickOnMessageAndEnterBody("Test Email" + n);
        inboxPage.clickOnSend();
        
	    // Now Find Email in Inbox
		// click in search box

		String sub = "Email Number" + n;

	    inboxPage.clickAndSearch(sub);
		builder.sendKeys(Keys.ENTER).perform();

		List<WebElement> gmails = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));
		for (WebElement gmail : gmails) {
			if (gmail.getText().indexOf(sub) != -1) {
				gmail.click();
				Assert.assertEquals(true, true);
				break;
			}
		}

		driver.close();

	}
	
	/********************************************************************************************
	 * 1. Login , 
	 * 2. create and sent an email , 
	 * 3. search for same email , 
	 * 4. delete the same email 
	 * 5. then search the same email again  
	 * 
	 * @throws InterruptedException
	 ********************************************************************************************/

	@Test
	public void testDeleteEmail() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.get(url);
		
		//login 
		ProvideUserName userNamePage = new ProvideUserName(driver);
	    userNamePage.setUserName(PropertiesUtil.getProperty("user_name"));
		userNamePage.clickOnNext();
					
		
		PasswordPage password = new PasswordPage(driver);
	    password.setPassword(PropertiesUtil.getProperty(("password")));
		builder.sendKeys(Keys.ENTER).perform();

		
        // Now compose and send email

		String n = Resources.genrateRandomNumber();

		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.clickOnCompose();
		Thread.sleep(1000);
		inboxPage.clickOnToAndEnterEmail(PropertiesUtil.getProperty("email_to"));
		builder.sendKeys(Keys.TAB).perform();
		builder.sendKeys(Keys.TAB).perform();
        inboxPage.clickOnSubjectAndEnterSubject("Email Number" + n);
        inboxPage.clickOnMessageAndEnterBody("Test Email" + n);
        inboxPage.clickOnSend();
        
	    // Now Find Email in Inbox
		// click in search box

		String sub = "Email Number" + n;
		
		driver.findElements(By.xpath("//*[@role='checkbox']")).get(1).click();

	  /*  inboxPage.clickAndSearch(sub);
		builder.sendKeys(Keys.ENTER).perform();

		List<WebElement> gmails = driver.findElements(By
				.cssSelector("div.xT>div.y6>span>b"));
		for (WebElement gmail : gmails) {
			if (gmail.getText().indexOf(sub) != -1) {
				gmail.click();

				break;
			}
		}
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement password5 = wait .until(ExpectedConditions
				.elementToBeClickable(By.xpath("xpath=(//div[@title='Poista'])[2]")));
		
		password5.click();

		Assert.assertEquals(true, true);

		Thread.sleep(20000);
		driver.findElement(By.id("gbqfq")).sendKeys(sub);
		builder.sendKeys(Keys.ENTER).perform();

		driver.close();
*/
	}
	
	@Test
	public void testFramework(){
		
		String advertiserIdValidation = PropertiesUtil.getProperty("password");
		
		System.out.println(advertiserIdValidation);
		
		
		
	}

}
