package org.annotation;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hotelbooking extends Baseclass{
	@BeforeClass
	public static void beforeclass()
	{
		getdriver();
	}
	@AfterClass
	public static void afterclass()
	{
		//quitwindow();
	}
	@Test
	public void login() throws IOException, InterruptedException
    {
		Hotelbooking hb=new Hotelbooking();
		WebElement txtusername=findelementbyid("username");
		String username=readdatafromcell("Sheet1", 3, 0);
		elementsendkey(txtusername, username);
		WebElement txtpassword=findelementbyid("password");
		String password=readdatafromcell("Sheet1", 3, 1);
		System.out.println(password);
		elementsendkey(txtpassword, password);
		WebElement btnlogin=findelementbyid("login");
		btnclick(btnlogin);
		
		WebElement txtloginsucess=findelementbyid("username_show");
		String actsucessvalue=getattribute(txtloginsucess);
		Assert.assertEquals("Verify after login sucess msg","Hello manojkumarv!",actsucessvalue);
		
		WebElement ddlloc=findelementbyid("location");
		String txt1=readdatafromcell("Sheet1", 3, 2);
		elementsendkey(ddlloc, txt1);
		WebElement ddlhotels=findelementbyid("hotels");
		String txt2=readdatafromcell("Sheet1", 3, 3);
		elementsendkey(ddlhotels, txt2);
		WebElement ddltype=findelementbyid("room_type");
		String txt3=readdatafromcell("Sheet1", 3, 4);
		elementsendkey(ddltype, txt3);
		WebElement ddlnorooms=findelementbyid("room_nos");
		String txt4=readdatafromcell("Sheet1", 3, 5);
		elementsendkey(ddlnorooms, txt4);
		WebElement ddlcheckin=findelementbyid("datepick_in");
		String txt5=readdatafromcell("Sheet1", 3, 6);
		elementsendkey(ddlcheckin, txt5);
		WebElement ddlcheckout=findelementbyid("datepick_out");
		String txt6=readdatafromcell("Sheet1", 3, 7);
		elementsendkey(ddlcheckout, txt6);
		WebElement ddladultroom=findelementbyid("adult_room");
		String txt7=readdatafromcell("Sheet1", 3, 8);
		elementsendkey(ddladultroom, txt7);
		WebElement btnsearch=findelementbyid("Submit");
		btnclick(btnsearch);
		
		WebElement txtsucessselecthotel=findelementbyXpath("//td[text()='Select Hotel ']");
		String actsucessvalue1=txtsucessselecthotel.getText();
		System.out.println(actsucessvalue1);
		Assert.assertEquals("Verify after Select Hotel sucess msg", "Select Hotel", actsucessvalue1);
		
		
		WebElement rbtn=findelementbyid("radiobutton_0");
		btnclick(rbtn);
		WebElement btncontinue=findelementbyid("continue");
		btnclick(btncontinue);
		
		WebElement txtsucessbookHotel=findelementbyXpath("//td[text()='Book A Hotel ']");
		String actsucessvalue2=txtsucessbookHotel.getText();
		System.out.println(actsucessvalue2);
		Assert.assertEquals("Verify after Book Hotel sucess msg","Book A Hotel",actsucessvalue2);
		
		WebElement txtfirstname=findelementbyid("first_name");
		elementsendkey(txtfirstname, "Manojkumar");
		WebElement txtlasttname=findelementbyid("last_name");
		elementsendkey(txtlasttname, "v");
		WebElement txtaddress=findelementbyid("address");
		elementsendkey(txtaddress, "30 illam south street");
		WebElement txtccnum=findelementbyid("cc_num");
		elementsendkey(txtccnum, "1234567898765432");
		WebElement txtcctype=findelementbyid("cc_type");
		elementsendkey(txtcctype, "VISA");
		WebElement txtexpmonth=findelementbyid("cc_exp_month");
		elementsendkey(txtexpmonth, "April");
		WebElement txtexpyr=findelementbyid("cc_exp_year");
		elementsendkey(txtexpyr, "2022");
		WebElement txtcvvno=findelementbyid("cc_cvv");
		elementsendkey(txtcvvno, "933");
		WebElement btnbooknow=findelementbyid("book_now");
		btnclick(btnbooknow);
		
		Thread.sleep(10000);
		WebElement txtsucessConfirmation=findelementbyXpath("//td[text()='Booking Confirmation ']");
		String actsucessvalue3=txtsucessConfirmation.getText();
		Assert.assertEquals("Verify after Book Hotel sucess msg","Booking Confirmation",actsucessvalue3);
		
		WebElement txtorderno=findelementbyid("order_no");
		String getatt = getattribute(txtorderno);
		System.out.println(getatt);
		writecdata("Sheet1",3 , 9, getatt);
    }
	

}
