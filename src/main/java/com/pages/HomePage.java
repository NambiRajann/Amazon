package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class HomePage {
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement list_Category;
	@FindBy(id="nav-search-dropdown-card")
	WebElement button_List;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement txtBox_Search;
	@FindBy(id="nav-search-submit-button")
	WebElement button_Search;
	
	
	
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void verifyTitle(){
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Amazon.in")){
			System.out.println("Amazon india opened");
		}
	}
	
	public void selectCategory()
	{
		button_List.click();
		Select select = new Select(list_Category);
		select.selectByVisibleText("Computers & Accessories");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
}
