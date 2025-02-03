package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\TestData\\TestData.xlsx";
		
		ExcelUtility eu = new ExcelUtility(path);
		
		int totalRow = eu.getRowCount("sheet1");
		int totalCol = eu.getCellCount("sheet1",1);
		
		String loginData[][] = new String[totalRow][totalCol];
		
		for(int i=1; i<=totalRow; i++) {
			
			for(int j=0; j<totalCol; j++) {
				
				loginData[i-1][j] = eu.getCellData("sheet1", i, j);
			}
		}
		
		return loginData;
	}
	
}
