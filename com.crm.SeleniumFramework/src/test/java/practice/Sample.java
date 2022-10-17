package practice;

//import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "C:\\Users\\Siddhant\\Desktop\\selenium\\chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver = new ChromeDriver();
		
		//File propFile = new File("./common_Data.property.txt");
		FileInputStream fis = new FileInputStream("./common_Data.property.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username = pro.getProperty("un");
		String pswd = pro.getProperty("pw");
		System.out.println(value);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		
		

	}

}
