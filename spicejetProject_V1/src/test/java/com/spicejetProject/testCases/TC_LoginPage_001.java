package com.spicejetProject.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spicejetProject.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
				
		LoginPage LP = new LoginPage(driver);
		LP.clickLogin();
		
		WebElement star = LP.returnStar();		
		BaseClass.driverWait(star,20);
			
		LP.setUserName(UN);
		logger.info("Username entered");
		
		LP.setPassword(pwd);
		logger.info("Password entered");
		
		LP.clickLoginButton();
		logger.info("Clicked on login button");
		
		WebElement text = LP.returnText();
		BaseClass.driverWait(text,20);
		
		if((LP.getWelcomeText1().contains(name))&&(LP.getWelcomeText2().contains(name)))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
			
		}
		else
		{		
			logger.info("Test case failed");
			captureScreen("TC_LoginPage_001");	
			Assert.assertTrue(false);		
		}
	}	
}
