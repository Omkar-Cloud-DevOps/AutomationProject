package com.TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageClass.HomePage;
import com.PageClass.LoginPage;
import com.PageClass.MyAccountPage;

import utility.DataProviders;

public class TC_003_LoginDDT extends TestBase{
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class, groups="Master")
	public void verifyLoginDDT(String email, String password, String exp) {
		
		try {
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean status =  ma.verifyLogin();
		
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(status==true) {
				
				ma.clickLogout();
				Assert.assertTrue(true);
			
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(status==true) {
				
				ma.clickLogout();
				Assert.assertTrue(false);
			
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			
			Assert.fail();
		}
	}

}
