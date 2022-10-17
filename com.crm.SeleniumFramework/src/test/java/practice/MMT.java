package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMT {
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
	//Random ran = new Random();
	//int RanNum = ran.nextInt(1000);
	FileInputStream fis1 = new FileInputStream("./MMTSH.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	Sheet sh = book.getSheet("MmtSh");
	Row ro = sh.getRow(0);
	Cell cel = ro.getCell(0);
	String data = cel.getStringCellValue();
	System.out.println(data);
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.id("fromCity")).sendKeys(data);
	driver.findElement(By.xpath("//p[text()[contains(.,'Devi Ahilyabai Holkar International Airport')]]")).click();
	FileInputStream fis2 = new FileInputStream("./MMTSH.xlsx");
	Workbook book1 = WorkbookFactory.create(fis2);
	Sheet sh1 = book1.getSheet("MmtSh");
	Row ro1 = sh1.getRow(0);
	Cell cel1 = ro1.getCell(1);
	String data1 = cel1.getStringCellValue();
	System.out.println(data1);
	driver.findElement(By.id("toCity")).sendKeys(data1);
	driver.findElement(By.xpath("//div[@class='calc60']/descendant::p[text()='Goa, India']")).click();
	
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Sat Oct 08 2022']")).click();
	driver.findElement(By.xpath("//p[text()='Tap to add a return date for bigger discounts']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Fri Oct 14 2022']")).click();
	driver.findElement(By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']")).click();
	driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='adults-2']")).click();
	driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='children-1']")).click();
	driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-2']")).click();
	driver.findElement(By.xpath("//div[@class='right makeFlex hrtlCenter']/button[@class='primaryBtn btnApply pushRight']")).click();
	driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
	
	
	
	
	
	
//div[@class='dateInnerCell']/descendant::
}
}
