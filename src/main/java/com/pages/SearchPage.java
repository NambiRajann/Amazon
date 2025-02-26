package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchPage {
	
	WebDriver driver;
	String value = "";
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement txtBox_Search;
	@FindBy(id="nav-search-submit-button")
	WebElement button_Search;
	
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
     public void enterSearchValue(String value){
		
		txtBox_Search.sendKeys(value);
		button_Search.click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
