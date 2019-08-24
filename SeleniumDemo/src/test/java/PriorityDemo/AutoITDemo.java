package PriorityDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		test();
	}
	public static void test() throws IOException, InterruptedException 
	{
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		Runtime.getRuntime().exec("E:\\Automation\\AutoIT\\FileUploadScript.exe");
		Thread.sleep(3000);
	}

}
