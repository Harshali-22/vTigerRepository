package Practice.TestNG;

import org.testng.annotations.Test;

public class ContactTest {

	@Test(priority=-1,dependsOnMethods="deleteContactTest")
	public void createContactTest() {
		System.out.println("Execute createContactTest with ---> HDFC ");
	}

	@Test(invocationCount=2)
	public void modifyContactTest() {
		System.out.println("Execute modifyContactTest with HDFC ---> ICICI ");
	}
	@Test//(priority=0)
	public void deleteContactTest() {
	System.out.println("Execute delete contact Test ---> ICICI ");	
	}

	
}