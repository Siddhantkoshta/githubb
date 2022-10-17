package com.crm.Campaign;

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

import com.crm.Generic_Utilities.Excel_Utility2;
import com.crm.Generic_Utilities.Excel_Utility3;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		File_Utility flib = new File_Utility();
		String URL = flib.getPropertyKeyValue1("url");
		String username = flib.getPropertyKeyValue1("un");
		String pswd = flib.getPropertyKeyValue1("pw");
		
		
		
		
		
		/*FileInputStream fis = new FileInputStream("./common_Data.property.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username = pro.getProperty("un");
		String pswd = pro.getProperty("pw");
		System.out.println(value);
		*/
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRanDomNum();
		
		 Excel_Utility2 elib = new Excel_Utility2();
		 String data = elib.getDataFromExcel("product", 0, 0)+RanNum;
		 Excel_Utility3 elib1 = new Excel_Utility3();
		 String data1 = elib1.getDataFromExcel("campaignSh", 0, 0)+RanNum;
		
		/*FileInputStream prod = new FileInputStream("./productDetails.xlsx");
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		Workbook book = WorkbookFactory.create(prod);
		Sheet sh = book.getSheet("product");
		Row ro = sh.getRow(0);
		Cell cel = ro.getCell(0);
		String data = cel.getStringCellValue()+RanNum;
		*/
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		//driver.findElement(By.id("more")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		/*FileInputStream cam = new FileInputStream("./campaignSheet.xlsx");
		Workbook book1 = WorkbookFactory.create(cam);
		Sheet sh1 = book1.getSheet("campaignSh");
		Row ro1 = sh1.getRow(0);
		Cell cel1 = ro1.getCell(0);
		String data1 = cel1.getStringCellValue()+RanNum;
		*/
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
