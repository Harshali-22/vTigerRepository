package Practive_DataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//	Step 1 : Get the excel path location & java Object of the physical Excel file.
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		
//	Step 2 : Open WorkBook in Read Mode.
		Workbook wb= WorkbookFactory.create(fis);
		
//	Step 3 : Get the control of the "org" Sheet.
		Sheet sh=wb.getSheet("org");
		
//	Step 4 : Get the control of the "1st" Row.
		Row row=sh.getRow(1);
		
//	Step 5 : Get the control of the "2nd" Cell & read the String Data.
		Cell cel=row.getCell(2);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		
//Use method chaining
		String TCName = wb.getSheet("org").getRow(1).getCell(1).getStringCellValue();
		String orgName = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue();
//		double headC = wb.getSheet("org").getRow(1).getCell(3).getNumericCellValue();
//		[Better practice to store all data in String coz sendkeys() always accepts String.
//		OR use toString method to convert int data in String]
//		String headC1 = wb.getSheet("org").getRow(1).getCell(3).toString();
		String headC = wb.getSheet("org").getRow(1).getCell(3).getStringCellValue();
		System.out.println(" TestCaseName: "+TCName+"\n OrgName : "+orgName+"\n Head Count: "+headC);
//	Step 6 : Close the WorkBook.
		wb.close();
		
	}

}
