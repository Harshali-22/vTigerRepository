package Practice.TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class sampleReportTest {
	
	public ExtentReports report;
	
	@Test
	public void createContactTest() {
		
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to cntact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
	}

	@Test
	public void createContactOrg() {
		
		ExtentTest test=report.createTest("createContactOrg");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to cntact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
	}
		
	@Test
	public void createContactWithPhoneNumberTest() {
		
		ExtentTest test=report.createTest("createContactWithPhoneNumberTest");
		
		test.log(Status.INFO,"Login to app");
		test.log(Status.INFO,"navigate to cntact page");
		test.log(Status.INFO,"create contact");
		
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is create");
		}
		else {
			test.log(Status.FAIL,"contact is not created");
		}
	}
}
