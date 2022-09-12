package Akhil_maven.Ak007;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import Utility.BrowserUtility;


public class App 
{
	public static WebDriver driver;
    
     @Test(priority=1)
     public void test() {
    	 
//    	BrowserUtility.setDriver("Chrome");
//      driver = BrowserUtility.getDriver();
//      driver.manage().window().maximize();
//      driver.get("https://www.google.com"); 
    System.out.println("p1");
     }

   @Test(priority=0)
   public void A()
   {
	   System.out.println("A");
   }
   @Test(priority=0)
   public void B()
   {
	   System.out.println("B");
   }
   

}
