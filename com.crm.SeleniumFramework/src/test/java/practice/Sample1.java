package practice;

import org.testng.annotations.Test;

public class Sample1 {
	
	@Test (priority = 1)
	public void createCustomer()
	{
		System.out.println("Customer details created sucessfully");
	}
	@Test(priority = 2)
	public void modifyCustomer()
	{
		System.out.println("Customer details modify sucessfully");
	}
	@Test(priority = 3)
	public void deleteCustomer()
	{
		System.out.println("Customer details delete sucessfully");
	}

}
