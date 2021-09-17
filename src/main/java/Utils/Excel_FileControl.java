package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_FileControl {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public Excel_FileControl(String path, String sheetname) {
		
		try {
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetname);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int Get_RowCount() {
		
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int Get_ColCount() {
		
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}
	
	public String getCellDataString(int rownum, int colnum) {
		
		String celldata = null;
		try {
			celldata = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return celldata;
	}

}
