package Practice_Org_Contact_Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

// Get data from Properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String browser = pObj.getProperty("Browser");
		String url = pObj.getProperty("Url");
		String username = pObj.getProperty("Username");
		String password = pObj.getProperty("Password");
		
// Generate the random number
		Random random=new Random();
		int randomInt=random.nextInt(10000);
// Get data from Excel file
		FileInputStream fisEx=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fisEx);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		Cell cell=row.getCell(2);
		String orgName=cell.getStringCellValue() + randomInt;
		System.out.println(orgName);
		
		WebDriver driver=null;
		 if (browser.equals("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if (browser.equals("firefox")) {
			 driver=new FirefoxDriver();
		 }
		 else if (browser.equals("edge")) {
			 driver=new EdgeDriver();
		 }
		 else {driver=new ChromeDriver();}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get(url);
		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("//td[@class='small']//a[text()='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		 
// Verify Header message with Expected result
		 String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if (headerInfo.contains(orgName)) {
			 System.out.println(orgName + " is created ===PASS");
		 }
		 else {
			 System.out.println(orgName + " is not created ===FAIL");
		 }
// Verify Header message with Expected result
		 String ActOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		 if (ActOrgName.equals(orgName)) {
			 System.out.println(orgName + " is created ===PASS");
		 }
		 else {
			 System.out.println(orgName + " is not created ===FAIL");
		 }
// Logout
		 driver.quit();
		 
	}

}
