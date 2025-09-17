package Practice_DataDrivenTesting.HWTasks;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddMobileAndverifyInCart {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
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
		if (prodDisplayed.equals(addedProd)){
			System.out.println(prodDisplayed +" is added to cart successfully");
			
		}
		driver.close();
	}

}
