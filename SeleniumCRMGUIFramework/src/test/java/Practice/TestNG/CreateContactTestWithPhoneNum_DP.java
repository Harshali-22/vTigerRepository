package Practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestWithPhoneNum_DP {

	
	@Test(dataProvider="getData")
	public void createContactWithNumTest(String name, String lastname,long contact) {
		System.out.println("Name:"+name+" "+lastname+"\n"+"Contact:"+contact);
	}
	
	@DataProvider
	public Object getData() {
		Object[][] objArr= {{"Harshali","Khedekar",1234567890l},
							{"Prachi","Sawant",2345678901l},
							{"Nilam","Jirapure",3456789012l}
							};
		return objArr;
	}
}
