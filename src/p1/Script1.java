package p1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(A.class)
public class Script1 {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public WebDriver e;
	public EventFiringWebDriver driver;
	
	@BeforeMethod
	public void openApp()
	{
		e=new ChromeDriver();
		driver=new EventFiringWebDriver(e);
		driver.register(new B());
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
