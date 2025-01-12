package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("rawtypes")
public class ExcelUtiity 
{
	
	public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
	
	public static String getTestData(int rowNumber, int cellNumber) throws  IOException, InvalidFormatException {

		// Create File class object.
		
		File file = new File("/Users/praveenbr/IdeaProjects/JavaUdemy/Selenium/QA-Automation/ExcelData/TestData.xlsx");

		// Create Workbook object.
		
		
		XSSFWorkbook book = new XSSFWorkbook(file);

		// Create Sheet object.
		
		Sheet sheet =  (Sheet) book.getSheetAt(0);	
		//Sheet sheet = 	book.getSheetAt(0);
		

		// specify the row and cell number.
	
		return ((XSSFSheet) sheet).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	
	
	

	}
	
	
	public static String getCellData(String xlsheet,int rownum,int colnum) throws IOException
    {
		String file = "/Users/praveenbr/IdeaProjects/JavaUdemy/Selenium/QA-Automation/ExcelData/TestData.xlsx";
        fi=new FileInputStream(file);
        wb=new XSSFWorkbook(fi);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e)
        {
            data="";
        }
        wb.close();
        fi.close();
        return data;
    }

}
