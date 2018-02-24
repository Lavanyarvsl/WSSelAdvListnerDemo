package p1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(A.class)
public class Script 
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openApp()
	{
		driver=new ChromeDriver();
		driver.get("http://localhost");
	}
	
	@AfterMethod
	public void cclosApp()
	{
		driver.quit();
	}
	
  @Test
  public void testA() 
  {
	  driver.findElement(By.id("username")).sendKeys("admin");
  }
  

  @Test
  public void testB() 
  {
	  driver.findElement(By.name("pwd")).sendKeys("admin");
	  Assert.fail();
  }

}
