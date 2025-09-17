package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromRuntime_SeleniumTest {

	@Test
	
	public void createOrgTest() {
// Read common data from command Line	
		String browser=System.getProperty("Browser");
		String url=System.getProperty("Url");
		String username=System.getProperty("Username");
		String password=System.getProperty("Password");
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
		driver.get(url);

	}
	
}
