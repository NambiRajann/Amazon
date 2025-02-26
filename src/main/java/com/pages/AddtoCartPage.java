package com.pages;

import java.awt.Window;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage {

	WebDriver driver;

	@FindBy(xpath = "(//*[@id=\"submit.add-to-cart-announce\"])[2]")
	WebElement AddtoCart_button;
	@FindBy(xpath = "//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4")
	WebElement text_AddedToCart;

	public AddtoCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addToCart(String product) throws InterruptedException

	{
		driver.findElement(By.partialLinkText(product)).click();
		driver.manage().window().maximize();
		Set<String> WH = driver.getWindowHandles();

		int WH_C = 0;
		for (String i : WH) {
			WH_C = WH_C + 1;
			if (WH_C == WH.size()) {

				driver.switchTo().window(i);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript("window,scrollBy(0,600);");

				Actions actions = new Actions(driver);
				actions.moveToElement(AddtoCart_button).click().build().perform();

			}

		}

	}

	public void verifyItemAdded() {
		if (text_AddedToCart.isDisplayed()) {
			System.out.println("Item successfully added to cart!!!!");
		}
	}

}
