package com.TestClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public static WebDriver driver;
	Properties pr;

	@BeforeClass(groups={"Sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		pr = new Properties();
		pr.load(fis);
		
		
		if(pr.getProperty("environment").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				
				dc.setPlatform(Platform.WIN11);
		
			}else if(os.equalsIgnoreCase("linux")) {
				
				dc.setPlatform(Platform.LINUX);
			
			}else {
				
				System.out.println("No matching OS found..");
				return;
			}
				
			
			
			switch(br.toLowerCase()) {
			
			case "chrome": dc.setBrowserName("chrome"); break;
			case "firefox": dc.setBrowserName("firefox"); break;
			case "edge": dc.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser found."); return;
			
			}
			
			driver = new RemoteWebDriver(new URL("http://172.31.64.1:4444/wd/hub"),dc);
		}
		
		
		if(pr.getProperty("environment").equalsIgnoreCase("local")) {
			
			
			switch(br.toLowerCase()) 
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			default: System.out.println("Invalide browser name."); return;
			
			}
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(pr.getProperty("url"));

	}

	@AfterClass(groups={"Sanity", "Regression", "Master"})
	public void tearDown() {

		driver.quit();
	}
	
	
	
	public String captureScreen(String tname) throws IOException{
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	
	public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumeric() {
		
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String alphaNumeric() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedString +"@"+ generatedNumber;
	}


}
