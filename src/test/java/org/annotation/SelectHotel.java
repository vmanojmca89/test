package org.annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends Baseclass{
	
	public SelectHotel()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement rbselect;
	
	@FindBy(id="continue")
	private WebElement btnContinue;

	public WebElement getRbselect() {
		return rbselect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotels()
	{
		btnclick(getRbselect());
		btnclick(getBtnContinue());
	}
}
