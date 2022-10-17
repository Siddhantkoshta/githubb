package com.crm.Generic_Utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Baseclass {
		
		@BeforeSuite
		public void BS()
		{
			System.out.println("DataBase Connection");
		}
		
		@BeforeTest
		public void BT()
		{
			System.out.println("Execute in Parallel mode");
		}
		
		@BeforeClass
		public void BC()
		{
			System.out.println("Launching the Browser");
		}
		
		@BeforeMethod
		public void BM()
		{
			System.out.println("Login to Application");
		}
		@AfterMethod
		public void AM()
		{
			System.out.println("Logout to Application");
		}
		
		@AfterClass
		public void AC()
		{
			System.out.println("Close the Broswer");
		}
		
		@AfterTest
		public void AT()
		{
			System.out.println("Executed Sucessefully");
		}
		
		@AfterSuite
		public void AS()
		{
			System.out.println("DataBase Close");
		}
	

}
