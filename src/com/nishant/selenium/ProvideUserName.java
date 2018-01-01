package com.nishant.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProvideUserName {

	WebDriver driver;
	
	By providerUseName = By.id("identifierId");
	By clickOnNext = By.id("identifierNext");
	
	
	
	public ProvideUserName(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String stringUserName){
		driver.findElement(providerUseName).sendKeys(stringUserName);
		
	}
	
	public void clickOnNext(){
		driver.findElement(clickOnNext).click();
		
	}
	
	
}
