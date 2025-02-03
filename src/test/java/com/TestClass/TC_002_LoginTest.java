package com.TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageClass.HomePage;
import com.PageClass.LoginPage;
import com.PageClass.MyAccountPage;

public class TC_002_LoginTest extends TestBase{

	@Test(groups={"Sanity", "Master"})
	public void validateLogin() {
		
		try {
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(pr.getProperty("username"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLogin();
		
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean status =  ma.verifyLogin();
		
		Assert.assertTrue(status);
		
		}catch(Exception e) {
			
			Assert.assertFalse(false);
		}
	}
	
	
	
	
	
	
	
}
