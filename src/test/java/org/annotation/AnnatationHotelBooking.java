package org.annotation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnatationHotelBooking extends Baseclass{

	static WebDriver driver;
	@BeforeClass
	public static void beforeclass()
	{
		getdriver();
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("https://adactinhotelapp.com/");
//		driver.manage().window().maximize();
	}
    @AfterClass
    public static void afterclass()
    {
    	//driver.quit();
    }
    @Test
    public void hotelBooking() throws IOException, InterruptedException
    {
    	Login l=new Login();
    	l.login(readdatafromcell("Sheet1",3,0),readdatafromcell("Sheet1",3,1));
    	
    	SearchHotelc srchhotel=new SearchHotelc();
    	srchhotel.searchHotels(readdatafromcell("Sheet1",3,2), readdatafromcell("Sheet1",3,3), readdatafromcell("Sheet1",3,4), readdatafromcell("Sheet1",3,5), readdatafromcell("Sheet1",3,6), readdatafromcell("Sheet1",3,7), readdatafromcell("Sheet1",3,8), readdatafromcell("Sheet1",3,9));
    
    	SelectHotel sltHotel=new SelectHotel();
    	sltHotel.selectHotels();
    	
    	BookHotelc bkHotel=new BookHotelc();
    	bkHotel.bookhotels(readdatafromcell("Sheet1",5,0), readdatafromcell("Sheet1",5,1), readdatafromcell("Sheet1",5,2), readdatafromcell("Sheet1",5,3), readdatafromcell("Sheet1",5,4), readdatafromcell("Sheet1",5,5), readdatafromcell("Sheet1",5,6), readdatafromcell("Sheet1",5,7));
  
    	Thread.sleep(10000);
    	
    	BookingConfirmationc bkconfirm=new BookingConfirmationc();
    	WebElement txtOrderNum = bkconfirm.getTxtOrderNum();
    	String getattributte = getattribute(txtOrderNum);
    	writecdata("Sheet1", 3, 10, getattributte);
    	bkconfirm.bookingconfirmation();
    	//WebElement orderno=bkconfirm.getTxtOrderNum();
    	//String ono=getattribute(orderno);
   
    	//writecdata("Sheet1",3,10,ono);
    	
    	Cancelbookingc canclbking=new Cancelbookingc();
    	canclbking.cancelBooking(readdatafromcell("Sheet1",3,10));
    	
    	alertOk();
    }
    @After
    public void afterscreenshot() throws IOException
    {
    	
    }
    @Before
    public void beforescreenshot() throws IOException
    {
    	
    }
}
