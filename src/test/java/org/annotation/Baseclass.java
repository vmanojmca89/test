package org.annotation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	
	public static void getdriver()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	
	public static void quitwindow()
	{
		driver.quit();
	}
	 public WebElement findelementbyid(String name)
	 {
		   WebElement txtusername=driver.findElement(By.id(name));
		   return txtusername;
	 }
	 public WebElement findelementbyname(String name)
	 {
		   WebElement txtusername=driver.findElement(By.name(name));
		   return txtusername;
	 }
	 public WebElement findelementbyXpath(String name)
	 {
		   WebElement txtusername=driver.findElement(By.xpath(name));
		   return txtusername;
	 }
	 public String readdatafromcell(String sheet,int rownum,int cellno) throws IOException
	 {
	    	String res="";
	    	File f=new File("C:\\Users\\Admin\\eclipse-workspace\\Annotation\\ExcelBook\\Book1.xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=new XSSFWorkbook(fis);
			Sheet s=wb.getSheet(sheet);
			Row r=s.getRow(rownum);
			Cell c=r.getCell(cellno);
			CellType type=c.getCellType();
			switch(type)
			{
			case STRING:
				res=c.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(c))
				{
					Date datecellvalue=c.getDateCellValue();
					SimpleDateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy");
					res=dateformat.format(datecellvalue);
				}
				else
				{
					double numericval=c.getNumericCellValue();
					long check=Math.round(numericval);
					if(check==numericval)
					{
						res=String.valueOf(check);
					}
					else
					{
						res=String.valueOf(numericval);
					}
				}
				break;
				default:
					break;
			}
			return res;
	    }
	  public void selectbyvisibletext(WebElement element,String text)
	  {
		  Select s=new Select(element);
		  s.selectByVisibleText(text);
	  }
	    public void elementsendkey(WebElement findelement,String text)
	    {
	    	findelement.sendKeys(text);
	    }
	    public void btnclick(WebElement btlogin)
	    {
	    	btlogin.click();
	    }
	    public String getattribute(WebElement e)
		{
			String attribute=e.getAttribute("value");
			return attribute;
		}
	    public void alertOk()
	    {
	    	Alert alert=driver.switchTo().alert();
	    	alert.accept();
	    }
	    public void alertCancel()
	    {
	    	Alert alert=driver.switchTo().alert();
	    	alert.dismiss();
	    }
	    
	    public void writecdata(String sheetname,int rownum,int cellnum,String data) throws IOException
		{
			File f=new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Annotation\\\\ExcelBook\\\\Book1.xlsx");
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=new XSSFWorkbook(fis);
			Sheet s=wb.getSheet(sheetname);
			Row r=s.getRow(rownum);
			Cell c=r.createCell(cellnum);
			c.setCellValue(data);
			FileOutputStream fos=new FileOutputStream(f);
			wb.write(fos);
		}
}
