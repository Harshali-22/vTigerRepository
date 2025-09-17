package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");

		int rowCount = sh.getLastRowNum();
		String expectedId="tc_02";
		String details="";
		for (int i = 0; i <= rowCount; i++) {
			String data = "";

			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expectedId)) 
					{ for(int j =0;j<=sh.getRow(i).getLastCellNum();j++)
						{ details=sh.getRow(i).getCell(j).toString(); 
						System.out.println("Details : "+ details+ "\t");
						}
					}
				}
			

			catch (Exception e) {}
		}
		wb.close();

	}

}
