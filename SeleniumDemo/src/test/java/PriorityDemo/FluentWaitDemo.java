package PriorityDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	
	
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		test();
	}
	public static void test() throws InterruptedException
	{
		String projectPath=	System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(5000);		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.findElement(By.linkText("Selenium Tutorial - javatpoint")).click();
	
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   @SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(2, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement= driver.findElement(By.partialLinkText("Selenium Tutorial - javatpoint"));
		       if(linkElement.isEnabled()) {
		    	   System.out.println("Element found");
		    	   
		       }
		       return linkElement;
		       
		       
		     }
		   });
		   element.click();
		
		//Thread.sleep(5000);		
		driver.close();
		driver.quit();
	}

}
