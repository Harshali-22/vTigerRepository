package Practice_pom_repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {

	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy (name="user_password")
	WebElement password;
	
	@FindAll ({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	WebElement loginBtn;
	
	@Test
	public void sampleTest() {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/");
		
		SampleTestWithPom st=PageFactory.initElements(driver,SampleTestWithPom.class);
		
		st.username.sendKeys("admin");
		st.password.sendKeys("admin");
		
		driver.navigate().refresh();
		
		st.username.sendKeys("admin");
		st.password.sendKeys("admin");
		st.loginBtn.click();
		
		driver.quit();
	}

}
