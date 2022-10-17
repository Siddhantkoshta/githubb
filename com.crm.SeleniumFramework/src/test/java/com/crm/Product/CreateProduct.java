package com.crm.Product;

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

import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.Excel_Utility2;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.ObjectRepository.LoginPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*FileInputStream fis = new FileInputStream("./common_Data.property.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username = pro.getProperty("un");
		String pswd = pro.getProperty("pw");
		System.out.println(value);
		*/
		File_Utility flib = new File_Utility();
		String URL = flib.getPropertyKeyValue1("url");
		String username = flib.getPropertyKeyValue1("un");
		String pswd = flib.getPropertyKeyValue1("pw");
		driver.get(URL);
		
		LoginPage login = new LoginPage(driver);
		login.login(username, pswd);
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(pswd);
//		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		//String sid = "Siddhant";
		
		Java_Utility jlib = new Java_Utility();
		int RanNum = jlib.getRanDomNum();
		
		Excel_Utility2 elib = new Excel_Utility2();
		String data = elib.getDataFromExcel("product", 0, 0)+RanNum;
		String data1 = elib.getDataFromExcel("product", 0, 1)+RanNum;
		
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		
		/*
		 * FileInputStream prod = new FileInputStream("./productDetails.xlsx");
		 * Workbook book = WorkbookFactory.create(prod);
		Sheet sh = book.getSheet("product");
		Row ro = sh.getRow(0);
		Cell cel = ro.getCell(0);
		String data = cel.getStringCellValue()+RanNum;
			
		Row ro1 = sh.getRow(0);
		Cell cel1 = ro1.getCell(1);
		String data1 = cel1.getStringCellValue()+RanNum;
		System.out.println(data);
		*/
		driver.findElement(By.name("productname")).sendKeys(data);
		//System.out.println(data1);
		driver.findElement(By.id("productcode")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(1000);
		String actualData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if(actualData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		
		/*driver.findElement(By.id("11")).click();
		driver.findElement(By.linkText("del")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.name("productcategory")).click();*/
		
		
		
	}

}
