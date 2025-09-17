package com.crm.generic.homePageVerificationTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void homePageTest (Method mtd) {
		System.out.println(mtd.getName()+" Test Start");
		String expectedPage="Home Page"
				+ "";
		//Launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888");
		//Login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actPage=driver.findElement(By.xpath("//a[contains(.,'Home')]")).getText();
		Assert.assertEquals(actPage, expectedPage);
		System.out.println(mtd.getName()+" Test Ends");
		driver.quit();
	}
	
	@Test
	public void verifyHomePageLogo(Method mtd) {
		
		System.out.println(mtd.getName()+" Test Start");
	
		//Launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888");
		//Login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertTrue(status);
		System.out.println(mtd.getName()+" Test Ends");
		driver.quit();
	}
}
