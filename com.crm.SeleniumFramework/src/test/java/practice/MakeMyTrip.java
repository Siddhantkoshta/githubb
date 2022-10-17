package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse_Workspace\\com.crm.SeleniumFramework\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream("./MakeMyTripUrl.property.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//from
		String srcCity = "Bangkok, Thailand";
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srcCity+"'");
		driver.findElement(By.xpath("//p[text()='"+srcCity+"']")).click();
		
		//to
		String desCity = "Mumbai, India";
		WebElement des = driver.findElement(By.xpath("//input[@id='toCity']"));
		des.sendKeys("'"+desCity+"'");
		driver.findElement(By.xpath("//p[text()='"+desCity+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(1000);
		
		//departure date
		String month = "October 2022";
		String date = "19";
		
		//Dynamic xpath
		WebElement tarik = driver.findElement(By.xpath("//div[text()='"+month+"']" 
		+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
		
		tarik.click();
		
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		Thread.sleep(1000);

		//departure date
		String month1 = "October 2022";
		String date1 = "25";
		
		//Dynamic xpath
		WebElement tarik1 = driver.findElement(By.xpath("//div[text()='"+month1+"']" 
		+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']"));
		tarik1.click();
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* //Random ran = new Random();
		//int RanNum = ran.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("./MMTSH.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("MmtSh");
		Row ro = sh.getRow(0);
		Cell cel = ro.getCell(0);
		String data = cel.getStringCellValue();
		System.out.println(data);
		driver.findElement(By.id("fromCity")).sendKeys(data);
		driver.findElement(By.xpath("//p[text()[contains(.,'Devi Ahilyabai Holkar International Airport')]]")).click();
		FileInputStream fis2 = new FileInputStream("./MMTSH.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sh1 = book1.getSheet("MmtSh");
		Row ro1 = sh1.getRow(0);
		Cell cel1 = ro1.getCell(1);
		String data1 = cel1.getStringCellValue();
		System.out.println(data1);
		driver.findElement(By.id("toCity")).sendKeys(data1);*/
		
	
	}

}
