package com.crm.Organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic_Utilities.Excel_Utility3;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.PomOrganisation;

public class CreateOrganisation {
	
	
	public static void main(String[] args) throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility3 elib = new Excel_Utility3();
		
		String Browser = flib.getPropertyKeyValue1("browser");
	
		
		int RanNum = jlib.getRanDomNum();
		
		WebDriver driver = null;
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		wlib.waitForPageToLoad(driver);
		driver.get("http://localhost:8888/");
		
		//String URL = flib.getPropertyKeyValue1("url");
		String username = flib.getPropertyKeyValue1("un");
		String pswd = flib.getPropertyKeyValue1("pw");
		
		LoginPage login = new LoginPage(driver);
		login.login(username, pswd);
		
		HomePage home = new HomePage(driver);
		home.clickOrganizationLink();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		
		
		
		

	}

}
