package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgTest {

	@Test
	public static void main (String [] args) throws Throwable{
		
// Read data from Properties file
//		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
//		Properties pObj=new Properties();
//		pObj.load(fis);
//		
//		String browser=pObj.getProperty("Browser");
//		String url=pObj.getProperty("Url");
//		String username=pObj.getProperty("Username");
//		String password=pObj.getProperty("Password");
		
// Read common data from Json file
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./Data/AppCommonData.json"));
		JSONObject map=(JSONObject) obj;
				
		String browser=map.get("Browser").toString();
		String url=map.get("Url").toString();
		String username=map.get("Username").toString();
		String password=map.get("Password").toString();

// Read common data from CMD line
//		String browser=System.getProperty("Browser");
//		String url=System.getProperty("Url");
//		String username=System.getProperty("Username");
//		String password=System.getProperty("Password");
//		
// Generate teh random number
		Random random=new Random();
		int randomInt=random.nextInt(100);
		
// Read Test Script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("org");
		Row row=sh.getRow(1);
		String orgname=row.getCell(2).toString()+randomInt;
		wb.close();
		
		WebDriver driver=null;
		if (browser.equals("chrome"))
		{ driver=new ChromeDriver(); }
		else if (browser.equals("firefox"))
		{ driver=new FirefoxDriver(); }
		else if (browser.equals("edge"))
		{ driver = new EdgeDriver(); }
		else 
		{ driver=new ChromeDriver(); }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//step 1: login to application
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
//step 2: Navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
//step 3: click on "Create organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//step 4: Enter all details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//step 5: Logout
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		

	}
}
