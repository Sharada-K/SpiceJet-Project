package com.spicejetProject.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver rdriver;
	
	public LoginPage(WebDriver ldriver)
	{
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Login")
	WebElement loginClick;
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")
	WebElement userName;
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@name='ControlGroupLoginView$MemberLoginView2LoginView$ButtonLogIn']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='member-welcome-info']/h2")
	WebElement welcomeText1;
	
	@FindBy(xpath="(//span[@class='dropdown-caps'])[2]")
	WebElement welcomeText2;
	
	@FindBy(xpath="//div[@class='sc-credential-login-label mobileemailLogin']//span[@class='star']")
	WebElement star;
	
	@FindBy(xpath="//a[@id='Login']//span[@class='rightarrowclass']")
	WebElement logout;
	
	@FindBy(xpath="//div[@class='error_div']")
	WebElement errorMessage;
	
	@FindBy(xpath="//input[@id='popup_ok']")
	WebElement popupOk;
	
	public void clickLogin()
	{
		loginClick.click();
	}
	
	public void setUserName(String UN)
	{
		userName.sendKeys(UN);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public String getWelcomeText1()
	{
		return welcomeText1.getText();
	}
	
	public String getWelcomeText2()
	{
		return welcomeText2.getText();
	}
	
	public WebElement returnStar()
	{
		return star;
	}
	
	public WebElement returnText()
	{
		return welcomeText1;
	}
	
	public void clearUN()
	{
		userName.clear();
	}
	
	public void clearPwd()
	{
		password.clear();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
	public boolean errorMessagePresent()
	{
		if(errorMessage.isDisplayed()==true)
			return true;
		else 
			return false;
	}
	
	public boolean popupDisplayed()
	{
		if(popupOk.isDisplayed())
			return true;
		else
			return false;
	}
}
