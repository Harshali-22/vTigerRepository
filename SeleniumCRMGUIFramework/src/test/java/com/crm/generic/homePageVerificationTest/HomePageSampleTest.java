package com.crm.generic.homePageVerificationTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	@Test
	public void homePageTest (Method mtd) {
		SoftAssert assertObj=new SoftAssert();
		System.out.println(mtd.getName()+" Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertObj.assertEquals("Home", "Home-1");
		System.out.println("Step-3");
		Assert.assertEquals("Title-CRM","Title-CRM");
		System.out.println("Step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+" Test Ends");
		
	}
	
	@Test
	public void verifyHomePageLogo(Method mtd) {
		SoftAssert assertObj=new SoftAssert();
		System.out.println(mtd.getName()+" Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertObj.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName()+" Test Ends");
	}
}
