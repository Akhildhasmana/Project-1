package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
    XSSFSheet sheet;
	
	public  ExcelDataConfig(String excelpath) {
	
		
		
		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			  sheet=wb.getSheetAt(0);
		 
		} catch (IOException e) {
		
			System.out.println(e.getMessage());
		}
	}
		
		public String getData(int row,int col) {
			
			String data = sheet.getRow(row).getCell(col).getStringCellValue();
			return data;
		}
		
	}



