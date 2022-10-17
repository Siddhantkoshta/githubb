package com.crm.ObjectRepository;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomOrganisation {
	
	private static final String RanNum = null;

	public PomOrganisation(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);
	}
	
	FileInputStream fis1=new FileInputStream("./productDetails.xlsx");

	Workbook book=WorkbookFactory.create(fis1);
	Sheet sh = book.getSheet("product");
	Row row = sh.getRow(0);
	Cell cel = row.getCell(0);
	String data = cel.getStringCellValue()+RanNum;
	
	public WebElement getPlusMarkLink() {
		return plusMarkLink;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusMarkLink;
	
	
	public void plusMarkLink() {
		plusMarkLink.click();
	}
	
	
	@FindBy(name = "accountname")
	private WebElement organisationName;

	public WebElement getOrganizationName() {
		return organisationName;
	}
	
	public void organizationName(String data) {
		organisationName.sendKeys(data);
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement submitButton;
	
	
	
	
	
	
	
	
	

}
