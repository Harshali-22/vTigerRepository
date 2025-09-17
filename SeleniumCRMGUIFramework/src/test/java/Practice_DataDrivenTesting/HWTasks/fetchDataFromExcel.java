package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.time.Duration;
//import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fetchDataFromExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		String browser=null;
		String url=null;
		WebDriver driver=null;
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("flpkrt");
		Row row=sh.getRow(1);
		Cell brow=row.getCell(0);
		Cell flpk=row.getCell(1);
		browser=brow.toString();
//		System.out.println(browser);
		url=flpk.toString();
//		System.out.println(url);
		
//		catch (Exception e) {}
		
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.name("q")).submit();
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@data-id='MOBDPPZZPXVDJHSQ']//div[@class='KzDlHZ']")).getText());
		//List<WebElement> iphones=driver.findElements(By.xpath("//div[@class='cPHDOP col-12-12']"));
		wb.close();
		driver.quit();
	}

}
