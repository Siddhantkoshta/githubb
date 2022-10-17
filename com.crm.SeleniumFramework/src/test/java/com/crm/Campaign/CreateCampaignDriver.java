package com.crm.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Generic_Utilities.Excel_Utility3;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.LoginPage;

public class CreateCampaignDriver {

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
		String URL = flib.getPropertyKeyValue1("url");
		String username = flib.getPropertyKeyValue1("un");
		String pswd = flib.getPropertyKeyValue1("pw");
		
		driver.get(URL);
		
		
		LoginPage login = new LoginPage(driver);
		login.login(username, pswd);
		
		
		//driver.findElement(By.name("user_name")).sendKeys(username);
		//driver.findElement(By.name("user_password")).sendKeys(pswd);
		//driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String data1 = elib.getDataFromExcel("campaignSh", 0, 0)+RanNum;
		//String data1 = elib.getDataFromExcel("campaignSh", 0, 0)+RanNum;
		
		System.out.println(data1);
		Thread.sleep(1000);
		driver.findElement(By.name("campaignname")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String actualData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actualData.contains(data1))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		

	}

}
