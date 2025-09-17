package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadPropertyWriteExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String browser=pObj.getProperty("Browser");
		String url=pObj.getProperty("Url");
		String amznUrl=pObj.getProperty("AmznUrl");
		String username=pObj.getProperty("Username");
		String password=pObj.getProperty("Password");
		
		FileInputStream excel=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\Data.xlsx");
		Workbook wb=WorkbookFactory.create(excel);
//		try{
		Row row=wb.getSheet("writefromP").getRow(1);
		Cell cell=row.createCell(1, CellType.STRING);
		cell.setCellValue(browser);
		Cell cell1=row.createCell(2, CellType.STRING);
		cell1.setCellValue(url);
		Cell cell2=row.createCell(3, CellType.STRING);
		cell1.setCellValue(amznUrl);
		Cell cell3=row.createCell(4, CellType.STRING);
		cell1.setCellValue(username);
		Cell cell4=row.createCell(5, CellType.STRING);
		cell1.setCellValue(password);
//		}
//		catch (Exception e) {}
		// Tow write back data in Excel
//		finally {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\Desktop\\Harshali\\Data.xlsx");
		wb.write(fos);
		wb.close();
//		}
	}

}
