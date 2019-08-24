package PriorityDemo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	@Test(dependsOnGroups= {"sanity1"})
	public void Test1() 
	{
		System.out.println("I am inside test 1");
	}
	@Test(groups="sanity1")
	public void Test2()
	{
		System.out.println("I am inside test 2");
	}
	
	@Test(groups="sanity1")
	public void Test3()
	{
		System.out.println("I am inside test 3");
	}

}
