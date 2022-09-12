package Datadriven;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelDataConfig;
import Utility_dataprovider_ExcelReader.Data_provider;
import Utility_dataprovider_ExcelReader.ExcelRead;
import Utility_dataprovider_ExcelReader.ReadExcel;

public class HalfEbDayTest {
   WebDriver driver;
  ExcelDataConfig exl;
   ReadExcel read;
   @BeforeTest
	public void setup() throws IOException {
		
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4) );
	driver.get("https://www.ebay.com/");
	
	ExcelRead.readRows("D:\\excel\\ExcelDetails.xlsx");
	                                                                                                                                                                                                           
	}

	
	@Test//(priority=1,dataProvider="test_data" ,dataProviderClass = Data_provider.class)
	
	public void Ebay_reg(){//(String a , String b ,String c ,String d) {
		

		driver.findElement(By.linkText("register")).click();
//		driver.findElement(By.id("firstname")).sendKeys(a);
		driver.findElement(By.id("firstname")).sendKeys(exl.getData(2, 0));//by reading excel and calling calling the constructor
//		driver.findElement(By.id("Email")).sendKeys(c);
//		driver.findElement(By.id("password")).sendKeys(d);
//		driver.findElement(By.id("lastname")).sendKeys(b);
//		
		
		
		
	}
}
