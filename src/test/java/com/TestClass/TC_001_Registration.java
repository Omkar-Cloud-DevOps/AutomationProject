package com.TestClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageClass.HomePage;
import com.PageClass.RegistrationPage;

public class TC_001_Registration extends TestBase {


	@Test(groups={"Sanity", "Regression", "Master"})
	public void registerUser() throws InterruptedException, IOException {

		HomePage hm = new HomePage(driver);

		hm.clickMyAccount();
		hm.clickRegister();
		System.out.println(driver.getTitle());

		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumeric());
		
		String gPassword = alphaNumeric();
		
		rp.setPassword(gPassword);
		rp.setConfirmPassword(gPassword);
		rp.clickCheckBox();
		rp.submit();
		
//		System.out.println(rp.errorMsg());

		String confMsg = rp.successMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		
		rp.clickContinue();
		System.out.println(driver.getTitle());
		
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("./Screenshots//file1.png"));
	}
	

	
}
