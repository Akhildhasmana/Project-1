package Utility_dataprovider_ExcelReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelDataConfig;

public class Data_provider {

	ExcelDataConfig obj=new ExcelDataConfig("D:\\excel\\ExcelDetails.xlsx"); 



		
		@DataProvider
		public Object[][] test_data(){
			
			 Object[][]name=new Object[1][4];
			
			 name[0][0] = obj.getData( 1,0 ) ;//a
			 name[0][1] = obj.getData( 1,1 );//b
		
		 name[0][2] = obj.getData( 1, 2);//a
		 name[0][3] = obj.getData( 1, 3);//b
			 

//			
			return name;
			
			
		}
	@Test(dataProvider="test_data")
//	
	public void getname(String A ,String B ,String c , String d )
//	
	{
	System.out.println(A+B);	
	}

}
