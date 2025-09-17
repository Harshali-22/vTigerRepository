package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExccelWritePropertyfile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		FileInputStream pfis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\PropertyFile.properties");
		Properties pObj=new Properties();
		try{
		Sheet sh=wb.getSheet("data");
		Row row;
		int lastRow=sh.getLastRowNum();
		Cell cell;
		for (int i=0;i<lastRow;i++) {
			row=sh.getRow(i);
			int lastCell=row.getLastCellNum();
			for (int j=0;j<lastCell;j++) {
				cell=row.getCell(j);
				String data=cell.getStringCellValue();
		//		pObj.setProperty(data, row.getCell(j+1).toString());
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		}
		catch(Exception e) {}
		
		finally {
			wb.close();
		}
	}

}
