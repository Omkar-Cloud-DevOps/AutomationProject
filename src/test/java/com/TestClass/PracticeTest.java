package com.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageClass.HomePage;
import com.PageClass.RegistrationPage;

public class PracticeTest {
	
	
	WebDriver driver;


	@Test
	public void registerUser() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		HomePage hm = new HomePage(driver);

		hm.clickMyAccount();
		hm.clickRegister();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[@class='pull-right']//input[@type='checkbox']")).click();
		Thread.sleep(3000);
	
		System.out.println(driver.getTitle());
		driver.close();
	}


}
