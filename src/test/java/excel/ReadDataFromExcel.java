package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {

	
	@Test
	public static List<String> readDataFromExcelFile() throws IOException {
		
		String path =  System.getProperty("user.dir")+"\\ExcelFolder\\creds.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1"); //workbook.getSheetAt(0);
		
		int totalrows = sheet.getLastRowNum();// total no. of rows
		
		int totalcell = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total no. of rows "+totalrows);
		
		System.out.println("Total no. of cells "+totalcell);
		
		List<String> list = new ArrayList<>();
		
	
		for(int r=1;r<=totalrows;r++) {
			XSSFRow currentRow =sheet.getRow(r);
			//System.out.println(currentRow);
			
			for (int c=0;c<totalcell;c++) {
				
				XSSFCell cell =currentRow.getCell(c);
				
				String cellValue =cell.toString();	
			//	System.out.print(cellValue+"\t");
				//System.out.println();
				
				list.add(cellValue);
				System.out.print(cellValue+"\t");
			}
			System.out.println();
		}
workbook.close();
file.close();
return list;
		
		
	}
}
