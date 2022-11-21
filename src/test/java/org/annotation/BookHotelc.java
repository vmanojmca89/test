package org.annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelc extends Baseclass {
	
	public BookHotelc()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtfname;
	
	@FindBy(id="last_name")
	private WebElement txtlname;
	
	@FindBy(id="address")
	private WebElement txtaddress;
	
	@FindBy(id="cc_num")
	private WebElement txtccnum;

	@FindBy(id="cc_type")
	private WebElement txtcctype;
	
	@FindBy(id="cc_exp_month")
	private WebElement txtccexpmonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement txtccexpyear;
	
	@FindBy(id="book_now")
	private WebElement btnbooknow;
	
	@FindBy(id="cc_cvv")
	private WebElement txtccvno;


	public WebElement getTxtfname() {
		return txtfname;
	}

	public WebElement getTxtlname() {
		return txtlname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtccnum() {
		return txtccnum;
	}

	public WebElement getTxtcctype() {
		return txtcctype;
	}

	public WebElement getTxtccexpmonth() {
		return txtccexpmonth;
	}

	public WebElement getTxtccexpyear() {
		return txtccexpyear;
	}

	public WebElement getTxtccvno() {
		return txtccvno;
	}
	
	public WebElement getBtnbooknow() {
		return btnbooknow;
	}
	
	public void bookhotels(String fname,String lname,String address,String ccno,String cctype,String expmonth,String expyear,String cvvno)
	{
		elementsendkey(getTxtfname(),fname);
		elementsendkey(getTxtlname(),lname);
		elementsendkey(getTxtaddress(),address);
		elementsendkey(getTxtccnum(),ccno);
		selectbyvisibletext(getTxtcctype(),cctype);	
		selectbyvisibletext(getTxtccexpmonth(),expmonth);	
		selectbyvisibletext(getTxtccexpyear(),expyear);	
		elementsendkey(getTxtccvno(),cvvno);
		btnclick(getBtnbooknow());
	}
}
