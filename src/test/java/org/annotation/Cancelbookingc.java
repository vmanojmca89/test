package org.annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cancelbookingc extends Baseclass{
	
	public Cancelbookingc()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_id_text")
	private WebElement txtOrderNum;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	
	//@FindBy(name="ids[]")
	//private WebElement chkbox;
	
	@FindBy(xpath="//*[@id=\"booked_form\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]")
	private WebElement btnCancel;
	
	public WebElement getTxtOrderNum() {
		return txtOrderNum;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	//public WebElement getChkbox() {
		//return chkbox;
	//}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public void cancelBooking(String orderNum)
	{
		elementsendkey(getTxtOrderNum(),orderNum);
		btnclick(getBtnGo());
		//btnclick(getChkbox());
		btnclick(getBtnCancel());
	}

	

}
