package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtils 
{
	private static final String EXCEL_PATH = "./src/test/jave/resources/testData/test.xlsx";
	public Workbook book ;
	public Sheet sheet;
	
	public Object[][] getExcelData(String sheetName)
	{
		Object[][] excelData = null;
		
		try {
			FileInputStream fs = new FileInputStream(EXCEL_PATH);
			sheet  = book.createSheet(sheetName);
			book = WorkbookFactory.create(fs);	
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		excelData = new Object[row][col];
		
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<=col;j++)
			{
				excelData[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return excelData;
		
	}
	
	
	

}
