package com.spicejetProject.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://book.spicejet.com/");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")).sendKeys("kejrilerj");
		driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")).sendKeys("mfdlkfjlkjf");
		driver.findElement(By.xpath("//input[@name='ControlGroupLoginView$MemberLoginView2LoginView$ButtonLogIn']")).click();
		Thread.sleep(4000);
		//driver.switchTo().alert().accept();
		
		/*Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);*/
		
		/*Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();*/
		
		/*System.out.println(driver.findElement(By.xpath("//input[@id='popup_ok']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='popup_ok']")).click();*/
		
		System.out.println("Alert accepted");
		//driver.close();
	}

}
