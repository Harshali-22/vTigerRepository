package Practice_pom_repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/");
		WebElement username=driver.findElement(By.name("user_name"));
		WebElement password=driver.findElement(By.name("user_password"));
		WebElement loginBtn=driver.findElement(By.id("submitButton"));
		
		username.sendKeys("admin");
		password.sendKeys("admin");
		
		driver.navigate().refresh();
		
		username.sendKeys("admin");
		password.sendKeys("admin");
		loginBtn.click();
		
		driver.quit();
	}

}
