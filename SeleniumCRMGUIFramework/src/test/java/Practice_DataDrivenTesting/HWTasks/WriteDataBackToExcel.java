package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WriteDataBackToExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Properties pObj = new Properties();
		pObj.load(fis);
		String url=pObj.getProperty("AmznUrl");
		String Browser=pObj.getProperty("Browser");
		WebDriver driver;
		if (Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile");
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		driver.findElement(By.xpath("//button[@name='submit.addToCart']")).click();
		String prodDisplayed=driver.findElement(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")).getText();
		driver.findElement(By.id("nav-cart-count")).click();
		String addedProd=driver.findElement(By.xpath("//li[@class='sc-item-product-title-cont']//span[@class='a-truncate-cut']")).getText();
//		System.out.println(prodDisplayed);
//		System.out.println(addedProd);
		String data=driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
		System.out.println(data);
		FileInputStream fis1=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb =WorkbookFactory.create(fis1);
		try {
		Cell cell=wb.getSheet("write").getRow(1).createCell(0, CellType.STRING);
		cell.setCellValue(data);
		wb.write(fos);}
		catch(Exception e) {}
		finally {
		wb.close();
		driver.close();}
	}



	}


