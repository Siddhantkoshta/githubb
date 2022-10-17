package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//getter method
	
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPassWordTextField() {
		return passWordTextField;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}


	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passWordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement submitbutton;
	
	
	public void login(String username, String pswd)
	{
		userNameTextField.sendKeys(username);
		passWordTextField.sendKeys(pswd);
		submitbutton.click();
	}
	
}
