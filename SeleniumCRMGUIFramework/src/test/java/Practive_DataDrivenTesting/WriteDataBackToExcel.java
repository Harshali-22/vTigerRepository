package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//	Open workbook in read mode and specify cell and pass the data
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		Cell cell=row.createCell(4);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		
// 	Open workbook in write mode and save workbook
		FileOutputStream fos= new FileOutputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("=========Executed=======");
	
	}

}
