package Practice_BaseClass_SuiteExecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class createContact_BaseClass extends BaseClass {

	@Test (groups={"smoke"})
	public void createContact(){
		System.out.println("Execute createContact & verify");
	}
	@Test(groups={"regression"})
	public void createContactWithNum() {
		System.out.println("Execute createContactWithNum & verify ");
	}
}

