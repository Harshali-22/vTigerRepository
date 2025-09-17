package Practive_DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGui {

	public static void main(String[] args) throws Exception {
		
		String projectName="Insta_23";
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		Connection con=null;
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
//		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Harshali");
		Select select=new Select(driver.findElement(By.xpath("//div[@class='ReactModalPortal']//select[@name='status']")));
		select.selectByVisibleText("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
	// verify the project in DB
		boolean flag=false;
//step 1: load/register the database driver
	try {	Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
//Step2: connect to dataBase
			con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/projects", "root@%", "root");
			System.out.println("====Done===");
//Step3: Create sql statement
			Statement stat=con.createStatement();
//Step4: Execute select query & get result
			ResultSet resultSet=stat.executeQuery("select * from project");
			while (resultSet.next()) {
				String actProjectName=resultSet.getString(4);
				if (projectName.equals(actProjectName)) {
					flag=true;
					System.out.println(projectName + " is available === PASS");
				}
			}
	}
			catch(Exception e) {
				System.out.println("Exccetion handled");
			}
		if (flag==false) {
			System.out.println(projectName + " is not available === FAIL");
		}
//Step5: Close the connection
		con.close();
		driver.quit();
			
	}

}
