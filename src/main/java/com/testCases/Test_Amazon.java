package com.testCases;

import java.util.concurrent.TimeUnit;

import javax.xml.stream.XMLStreamException;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.pages.AddtoCartPage;
import com.pages.HomePage;
import com.pages.SearchPage;

public class Test_Amazon {

	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	AddtoCartPage addToCartPage;

	@BeforeSuite
	public void launchwebsite() {
		
		driver = new ChromeDriver();

		// open website
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		// maximize

		driver.manage().window().maximize();
	}

	@Test(priority = 0, enabled = true)
	public void HomePage() {
		homePage = new HomePage(driver);
		homePage.verifyTitle();
		homePage.selectCategory();

	}

	@Test(priority = 1, enabled = true)
	@Parameters("product")
	public void SearchPage(String product) {

		SearchPage sPage = new SearchPage(driver);
		sPage.enterSearchValue(product);

	}

	@Test(priority = 2, enabled = true)
	@Parameters("product")
	public void addToCart(String prodct) throws InterruptedException {
		addToCartPage = new AddtoCartPage(driver);
		addToCartPage.addToCart(prodct);
		Thread.sleep(3000);
		addToCartPage.verifyItemAdded();
	}

	@AfterSuite
	public void CloseChrome() {

		 driver.quit();
	}

}
