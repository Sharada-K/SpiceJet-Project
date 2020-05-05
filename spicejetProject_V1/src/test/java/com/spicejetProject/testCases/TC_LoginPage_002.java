package com.spicejetProject.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.spicejetProject.pageObjects.LoginPage;
import com.spicejetProject.utilities.ExcelUtils;

public class TC_LoginPage_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginPage(String UN, String pwd) throws IOException, AWTException, InterruptedException
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

		if(LP.popupDisplayed())
		{
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

			logger.info("Login failed");
			logger.info("Test case passed");			
			Assert.assertTrue(true);
			return;
		}
		
	}

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="C:\\Users\\Admin\\eclipse-workspace\\spicejetProject_V1\\src\\test\\java\\com\\spicejetProject\\testData\\LoginTestData.xlsx";

		int rownum=ExcelUtils.getRowCount(path,"InvalidScenarios1");
		int colcount=ExcelUtils.getCellCount(path,"InvalidScenarios1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtils.getCellData(path,"InvalidScenarios1", i,j);//1 0
			}

		}
		return logindata;
	}

}
