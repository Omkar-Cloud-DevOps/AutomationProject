package com.PageClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement txtConfPassword;

	@FindBy(xpath = "//div[@class='pull-right']//input[@type='checkbox']")
	WebElement checkBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMsg;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;

	public void setFirstName(String firstname) {

		txtFirstName.sendKeys(firstname);
	}

	public void setLastName(String lastname) {

		txtLastName.sendKeys(lastname);
	}

	public void setEmail(String email) {

		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {

		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {

		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String confPassword) {

		txtConfPassword.sendKeys(confPassword);
	}

	public void clickCheckBox() {

		checkBox.click();
	}

	public void submit() {

		btnSubmit.click();
	}

	public String successMsg() {

		return successMsg.getText();
	}

	public String errorMsg() {

		return errorMsg.getText();
	}

	public void clickContinue() {

		btnContinue.click();
	}

}
