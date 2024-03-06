package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {

	public static String[][] excelintegrate() throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("./datasheet/CreateLead1.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows including header :" +rows);
		int Column = sheet.getRow(1).getLastCellNum();
		System.out.println("number of columns :" +Column);
		String data[][]=new String[rows][Column];
		System.out.println("Print the cell values");
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < Column; j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(value);
				data[i-1][j]=value;
			}
		}
wb.close();
return data;
	}

}
