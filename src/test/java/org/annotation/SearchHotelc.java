package org.annotation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelc extends Baseclass{
	
	public SearchHotelc()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dDnlocation;
	
	@FindBy(id="username_show")
	private WebElement txtwelcomemsg;
	
	@FindBy(id="hotels")
	private WebElement dDnhotels;
	
	@FindBy(id="room_type")
	private WebElement dDnRoomType;
	
	@FindBy(id="room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id="datepick_in")
	private WebElement txtCheckInDate;
	
	@FindBy(id="datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id="adult_room")
	private WebElement dDnAdultsPerRoom;

	@FindBy(id="child_room")
	private WebElement dDnChildPerRoom;
	
	@FindBy(id="Submit")
	private WebElement btnSearch;

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getTxtwelcomemsg() {
		return txtwelcomemsg;
	}

	public WebElement getdDnhotels() {
		return dDnhotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}

	public WebElement getdDnChildPerRoom() {
		return dDnChildPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public void searchHotels(String location,String hotels,String roomType,String noofRooms,String checkindate,String checkoutdate,String adultperRoom,String childrenperRoom)
	{
		elementsendkey(getdDnlocation(),location);	
		elementsendkey(getdDnhotels(),hotels);	
		elementsendkey(getdDnRoomType(),roomType);	
		elementsendkey(getdDnRoomNo(),noofRooms);	
		elementsendkey(getTxtCheckInDate(),checkindate);
		elementsendkey(getTxtCheckOutDate(),checkoutdate);
		elementsendkey(getdDnAdultsPerRoom(),adultperRoom);	
		elementsendkey(getdDnChildPerRoom(),childrenperRoom);	
		btnclick(getBtnSearch());
	}

}
