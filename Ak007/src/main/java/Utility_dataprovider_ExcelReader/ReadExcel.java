package Utility_dataprovider_ExcelReader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main (String[]args)throws Exception{
		File src=new File("D:\\excel\\ExcelDetails.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet Sheet=wb.getSheetAt(0);

	    int rowcount =Sheet.getLastRowNum();
	    
	    System.out.println("The total rows is "+(rowcount+1)); 
	    
	    for(int i=0;i<=rowcount;i++)
	    {
	    
	   String dataall= Sheet.getRow(i).getCell(0).getStringCellValue();
	    	
	    	System.out.println ("data from rows is " +i+ "  is  "+dataall);
	    	}
		wb.close();
		
	}
}
