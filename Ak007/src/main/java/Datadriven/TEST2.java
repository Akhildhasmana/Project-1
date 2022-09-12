package Datadriven;

import org.testng.annotations.Test;

import Utility.ExcelDataConfig;

public class TEST2 {

	@Test
	public void read() {
		ExcelDataConfig exl=new ExcelDataConfig("D:\\excel\\ExcelDetails.xlsx");
		System.out.println(exl.getData(0, 0));
		
	}
	
	
}
