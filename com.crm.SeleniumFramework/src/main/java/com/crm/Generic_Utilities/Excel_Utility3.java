package com.crm.Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility3 {
	/**
	 * this method is used to fetch the data form excel 
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Siddhant
	 */
	public String getDataFromExcel(String sheetName,int RowNum, int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./campaignSheet.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(RowNum);
		Cell cel = row.getCell(cellNum);
		String data = cel.getStringCellValue();
		return data;
	}
}
