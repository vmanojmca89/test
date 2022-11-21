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

public class Annotationcls {
	static WebDriver driver;
	@BeforeClass
	public static void beforeclass()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
    @AfterClass
    public static void afterclass()
    {
    	//driver.quit();
    }
    @Test
    public void login()
    {
    	WebElement txtusername=driver.findElement(By.id("username"));
    	txtusername.sendKeys("manojkumarv");
    	WebElement txtpassword=driver.findElement(By.id("password"));
    	txtpassword.sendKeys("600028");
    	WebElement btnlogin=driver.findElement(By.name("login"));
    	btnlogin.click();
    }
    @After
    public void afterscreenshot() throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\Annotation\\screenshot\\scrshot1.png");
		FileUtils.copyFile(source, destination);
    }
    @Before
    public void beforescreenshot() throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\Annotation\\screenshot\\scrshot2.png");
		FileUtils.copyFile(source, destination);
    }
}
