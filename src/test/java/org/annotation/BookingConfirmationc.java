package org.annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationc extends Baseclass {
	
	public BookingConfirmationc()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement linkitenerary;
	
	@FindBy(id="order_no")
	private WebElement txtOrderNum;

	public WebElement getTxtOrderNum() {
		return txtOrderNum;
	}
	
	public WebElement getLinkitenerary() {
		return linkitenerary;
	}



	public void bookingconfirmation() {
		
		btnclick(getLinkitenerary());
	}

}
