package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.Generic_Utilities.Excel_Utility3;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.LoginPage;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		
		String key = "webdriver.edge.driver";
		String value = "./msedgedriver.exe";
		
		
		//String key = "webdriver.chrome.driver";
		//String value = "./chromedriver.exe";
		System.setProperty(key, value);
	//	WebDriver driver = new EdgeDriver();
 
		
		WebDriver driver = new ChromeDriver();
		
		
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
	
		File_Utility flib = new File_Utility();
		String URL = flib.getPropertyKeyValue1("url");
		String username = flib.getPropertyKeyValue1("un");
		String pswd = flib.getPropertyKeyValue1("pw");
				
		driver.get(URL);
		
		//LoginPage login = new LoginPage(driver);
		LoginPage login = new LoginPage(driver);
		login.login(username, pswd);
		
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		//driver.findElement(By.id("more")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRanDomNum();
		
		Excel_Utility3 elib = new Excel_Utility3();
		String data1 = elib.getDataFromExcel("campaignSh", 0, 0)+RanNum;
		
		System.out.println(data1);
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


/*	
FileInputStream fis = new FileInputStream("./common_Data.property.txt");
Properties pro = new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String username = pro.getProperty("un");
String pswd = pro.getProperty("pw");
System.out.println(value);

Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		/*FileInputStream cam = new FileInputStream("./campaignSheet.xlsx");
		
		Workbook book1 = WorkbookFactory.create(cam);
		Sheet sh1 = book1.getSheet("campaignSh");
		Row ro1 = sh1.getRow(0);
		Cell cel1 = ro1.getCell(0);
		String data1 = cel1.getStringCellValue()+RanNum;
		*/
