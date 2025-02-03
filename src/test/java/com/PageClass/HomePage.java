package com.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver){
		
		super(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement btn_MyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement btn_register;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement btn_login;
	
	
	public void clickMyAccount() {
		
		btn_MyAccount.click();
	}
	
	
	public void clickRegister() {
		
		btn_register.click();
	}
	
	
	public void clickLogin() {
		
		btn_login.click();
	}
	
}
