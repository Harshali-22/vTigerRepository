package Practive_DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		Step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\CommonData.properties");
		
//		Step 2: using properties class, load all the keys
		Properties pObj=new Properties();
		pObj.load(fis);
		
//		Step 3: get the value based on key
		System.out.println(pObj.getProperty("Browser"));
		System.out.println(pObj.getProperty("Url"));
		System.out.println(pObj.getProperty("Username"));
		System.out.println(pObj.getProperty("Password"));
	}

}
