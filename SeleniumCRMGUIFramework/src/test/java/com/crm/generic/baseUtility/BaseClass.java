package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
public class BaseClass {

	@BeforeMethod (groups={"smoke","regression"})
	public void configBM() {
		System.out.println("===Login===");
	}
	@AfterMethod (groups={"smoke","regression"})
	public void cofingAM() {
		System.out.println("===Logout===");
	}
	@Parameters ("Browser")
	@BeforeClass (groups={"smoke","regression"})
	public void confingBC(String Browser) {
		System.out.println("===Launch the "+ Browser+" Browser===");
	}
	@AfterClass (groups={"smoke","regression"})
	public void configAC() {
		System.out.println("===Close the Browser===");
	}
	@BeforeSuite (groups={"smoke","regression"})
	public void configBS() {
		System.out.println("===Connect to DB , Report config===");
	}
	@AfterSuite (groups={"smoke","regression"})
	public void ConfigAS() {
		System.out.println("===close DB , Report Backup===");
	}
}
