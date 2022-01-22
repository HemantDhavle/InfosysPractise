package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLogic 
{
	private static final String path = "";
	public Workbook book ;
	public Sheet sheet;
	public Object[][] getData(String sheetName)
	{
		Object[][] data = null;
		try {
			FileInputStream fs = new FileInputStream(path);
				book=	WorkbookFactory.create(fs);
				sheet = book.getSheet(sheetName);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int col = sheet.getRow(0).getLastCellNum();
		int row = sheet.getLastRowNum();
		
		 data = new  Object[row][col];
		 for(int i =0;i<=row;i++)
		 {
			 for (int j=0;j<=col;j++)
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			 }
		 }
		 return data;
		
	}

}
