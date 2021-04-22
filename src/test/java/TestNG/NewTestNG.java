package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTestNG {
  
	
	static WebDriver obj = null;
	@BeforeTest 
	public static void BeforeT() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\TANU\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		obj = new ChromeDriver();
		obj.get("https://www.selenium.dev/downloads/");
		
		
	}
	
	
	
	@Test (priority=1)
  public static void test() {
	  obj.findElement(By.id("gsc-i-id1")).sendKeys("Test");
	  obj.findElement(By.id("gsc-i-id1")).sendKeys(Keys.ENTER);
	  obj.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  String ExpectedRes = "Programmable Search Engine";
	  String ActualRes = obj.getTitle();
	  Assert.assertEquals(ExpectedRes, ActualRes);
  }
	
	@Test  (priority=0)
	public static void tes2() {
		
		obj.findElement(By.className("releases-button")).click();
		obj.findElement(By.className("close-x")).click();
	}
	
	@AfterTest 
	
	public static void AfterT() {
		
		obj.close();
		
	}
	
}
