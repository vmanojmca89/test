package org.annotation;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Baseclass{
	
	public Login()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="login")
	private WebElement btnlogin;
	
	
    public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public void login(String userName,String password)
	{
		System.out.println(userName);
		System.out.println(password);
		elementsendkey(getTxtUsername(), userName);
		elementsendkey(getTxtPassword(), password);
		btnclick(btnlogin);
	}
	
}
