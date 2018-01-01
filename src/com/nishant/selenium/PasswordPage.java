package com.nishant.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {

	public PasswordPage(WebDriver driver) {
		this.driver = driver;
	} 
	WebDriver driver ;

	By providePassword = By.xpath("//input[@name='password']");

	
	
	public void setPassword(String password){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(providePassword));
		wb.sendKeys(password);
		

		
	}
	
	
	
	
	
}
