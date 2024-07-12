package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	
	@Test
	public void Excel() throws IOException {

		FileInputStream fis = new FileInputStream("/home/arunkumar/Documents/Login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		String[] username = null;
		
		for(int i=0; i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);   //iterates through sheets
				
				
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells1 = firstrow.cellIterator();
				Cell firstcell1 = cells1.next();
				Cell Secondcell1 = cells1.next();
				System.out.println(firstcell1 + "  "+ Secondcell1);
				
				Row SecondRow = rows.next();
				Iterator<Cell> cells2 = SecondRow.cellIterator();
				Cell firstcell2 = cells2.next();
				Cell Secondcell2 = cells2.next();
				System.out.println(firstcell2 + "  "+ Secondcell2);
			}
		}
		
	}
}
