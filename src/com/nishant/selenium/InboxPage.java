package com.nishant.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {

	WebDriver driver ;
	By clickOnCompose = By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div");
	By emailToElement = By.xpath(".//textarea[contains(@aria-label, 'To')]");
	By subject        = By.name("subjectbox");
	By messageBody    = By.xpath("(.//*[@aria-label='Message Body'])[2]");
	By send           = By.xpath("//div[text()='Send']");
	By searchBar      = By.id("gbqfq");
	
    public InboxPage(WebDriver driver) {
	this.driver = driver;
	}

    public void clickOnCompose(){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(clickOnCompose));
		wb.click();
    	
    }
	
    public void clickOnToAndEnterEmail(String emailAddress){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(emailToElement));
		wb.sendKeys(emailAddress);
    	
    }
    
    public void clickOnSubjectAndEnterSubject(String textSubject){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(subject));
		wb.sendKeys(textSubject);
    	
    }
    
    public void clickOnMessageAndEnterBody(String textMessage){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(messageBody));
		wb.sendKeys(textMessage);
    	
    }
    
    public void clickOnSend(){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(send));
		wb.click();
    	
    }
    
    public void clickAndSearch(String searchMessage){
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		wb.click();
		wb.sendKeys(searchMessage);
    	
    }
	
	
	
	
}
