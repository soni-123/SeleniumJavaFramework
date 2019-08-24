

package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;



public class TestNG_Demo {
	public static String browserName=null;
	WebDriver driver=null;
	private static Logger logger=LogManager.getLogger(Log4jDemo.class);

	@Parameters("browserName")
	@BeforeTest
	public void setUpTest()
	{
		String projectPath=	System.getProperty("user.dir");
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",projectPath+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}

	}

	@Test
	public void googleSearch() throws InterruptedException
	{
		driver.get("http://google.com");
		logger.info("navigate to google.com ");
		driver.findElement(By.name("q")).sendKeys("Automation Step by step");
		Thread.sleep(4000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();	
		driver.quit();
	}
}



