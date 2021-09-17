package Utils;

import org.testng.annotations.DataProvider;

public class Excel_DataProvider {
	
	public Object[][] testData(String path, String sheetname){
		Excel_FileControl excel = new Excel_FileControl(path, sheetname);
		
		int rowCount = excel.Get_RowCount();
		int colCount = excel.Get_ColCount();
		
		Object data[][] = new Object[rowCount - 1][colCount - 1];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount - 1; j++) {
				String celldata = excel.getCellDataString(i, j);
				data[i - 1][j] = celldata;
			}
		}
		return data;
	}
	//*******************************************************************ADD_Address-Data_Provider
	@DataProvider(name = "Add_Address")
	public Object[][] getData1(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "add_address");
		return data;
	}
	//*******************************************************************DELETE_Address-Data_Provider
	@DataProvider(name = "Delete_Address")
	public Object[][] getData2(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "delete_address");
		return data;
	}
	//*******************************************************************ValidLogin-Data_Provider
	@DataProvider(name = "Logindata")
	public Object[][] getData3(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "ValidLoginTest");
		return data;
	}
	//*******************************************************************InvalidLogin-Data_Provider
	@DataProvider(name = "InvalidData")
	public Object[][] getData4(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "InvalidLogin");
		return data;
	}
	//*******************************************************************No_ID_PasswrdLogin-Data_Provider
	@DataProvider(name = "No_ID_Passwrd_InvalidData")
	public Object[][] getData5(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "No_ID_Passwrd_InvalidTest");
		return data;
	}
	//*******************************************************************LogoutTest-Data_Provider
	@DataProvider(name = "LogoutData")
	public Object[][] getData6(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "LogoutTest");
		return data;
	}
	//*******************************************************************ProductTest-Data_Provider
	@DataProvider(name = "ProductData")
	public Object[][] getData7(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "SearchProductTest");
		return data;
	}
	//*******************************************************************ADDtoCart-Data_Provider
	@DataProvider(name = "ADDtoCartData")
	public Object[][] getData8(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "ADDtoCartTest");
		return data;
	}
	//*******************************************************************DeleteFromCart-Data_Provider
	@DataProvider(name = "DeleteFromCartData")
	public Object[][] getData9(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "DeleteFromCartTest");
		return data;
	}
	//*******************************************************************Register-Data_Provider
	@DataProvider(name = "RegisterData")
	public Object[][] getData10(){
		String path = ".\\Resources\\Test_Data.xlsx";
		Object data[][] = testData(path, "RegisterTest");
		return data;
	}
}

