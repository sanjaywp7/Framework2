package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	
XSSFWorkbook wb;

//Iterview Question: 
	//1. Where and ehow have you used constructor in your framework.

	public ExcelDataProvider ()
	{
		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
			//  catch block message 
				System.out.println("Unable to read Excel File "+e.getMessage());
			}		
	}

	// Note:  below is the example of method overloading where method name is same but type of parameter is different
	// Iterview Question: 
	//2. Where have you used 'method overloading in your framework.
	

	public String getStringData(int sheetIndex, int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();	
	}
	
	public String getStringData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();	
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	
	
	
}
