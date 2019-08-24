package PriorityDemo;

import org.testng.annotations.Test;
 
public class TestNGIgnoreDemo {



	public void Test1() 
	{
		System.out.println("I am inside test 1");
	}
	@Test
	public void Test2()
	{
		System.out.println("I am inside test 2");
	}
	
}
