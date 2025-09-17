package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\Asus\\\\Desktop\\\\Harshali\\\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("prod");
		int lastRow=sh.getLastRowNum();
		for(int i=1;i<=lastRow; i++) {
		Row row = sh.getRow(i);
		String brand=row.getCell(0).toString();
		String prod=row.getCell(1).toString();
		System.out.println(brand + "\t" + prod);
		}
		wb.close();
	}
}
