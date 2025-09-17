package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProject {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
// Read data from Properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String browser=pObj.getProperty("Browser");
		String dburl=pObj.getProperty("DbUrl");
		String dbusername=pObj.getProperty("DbUN");
		String dbpassword=pObj.getProperty("DbPwd");
		String ninzaUrl=pObj.getProperty("NinzaUrl");
		String ninzaUN=pObj.getProperty("NinzaUN");
		String ninzaPwd=pObj.getProperty("NinzaPwd");
		
		Random random=new Random();
		int randomInt=random.nextInt(1000);
// Read data from Excel
		FileInputStream fisEx=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fisEx);
		Sheet sh=wb.getSheet("project");
		Row row=sh.getRow(1);
		Cell cell=row.getCell(1);
		String projectManager=cell.getStringCellValue();
		Cell cell1=row.getCell(2);
		String ProjectName=cell1.getStringCellValue()+randomInt;
		
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
		driver.get(ninzaUrl);
		driver.findElement(By.id("username")).sendKeys(ninzaUN);
		driver.findElement(By.id("inputPassword")).sendKeys(ninzaPwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// create Project
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.className("btn btn-success")).click();
		driver.findElement(By.name("projectName")).sendKeys(ProjectName);
		driver.findElement(By.name("createdBy")).sendKeys(projectManager);
		Select sel=new Select(driver.findElement(By.xpath("//div[@class='ReactModalPortal']//select")));
		sel.selectByVisibleText("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//Verify in DB
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con=DriverManager.getConnection(dburl, dbusername, dbpassword);
		Statement stat=con.createStatement();
		ResultSet resultSet=stat.executeQuery("Select * from Projects");
		boolean flag=false;
		while (resultSet.next()) {
			String actProjectName=resultSet.getString(2);
			if (actProjectName.equals(ProjectName)) {
				flag=true;
				System.out.println(ProjectName+" is created successfully === PASSS");
			}
		}
		if (flag==true) {
			System.out.println(ProjectName+" is not created === FAIL");
		}
		wb.close();
		con.close();
		driver.quit();
	}

}
