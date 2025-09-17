package Practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DataProvider {

	@Test(dataProvider="getData")
	public void createContacTest (String firstName, String lastName) {
		System.out.println("Frist Name:"+firstName+" , Last Name:"+lastName );
	}
	@DataProvider
	public Object getData() {
//		Object[][] objArr=new Object[3][2];
//		objArr[0][0]="Harshali";
//		objArr[0][1]="Mahadik"
		Object[][] objArr= {{"Harshali","Khedekar"},{"Prachi","Sawant"},{"Nilam","Jirapure"}};
		return objArr;
	}
}
