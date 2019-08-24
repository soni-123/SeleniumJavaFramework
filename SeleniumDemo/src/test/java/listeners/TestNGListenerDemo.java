package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	@Test
	public void test1()
	{
		System.out.println("I am inside test1");
	}
	@Test
	public void test2() throws InterruptedException
	{
		System.out.println("I am inside test2");

		String projectPath=	System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by step");
		Thread.sleep(4000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
	}
	@Test
	public void test3()
	{
		System.out.println("I am inside test3");
		throw new SkipException("This Test is skipped");
	}
	
}
