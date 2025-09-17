package Practive_DataDrivenTesting;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

	//Step 1: parse Json physical file into java Object using JsonParse class.
		
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./Data/AppCommonData.json"));
//		FileInputStream fis=new FileInputStream("C:\\Users\\Asus\\Desktop\\Harshali\\AppCommonData.json");
//		Object obj=parser.parse(fis);
		
	//Step 2: Downcast Java Object to JSONObject type
		JSONObject map=(JSONObject) obj;
		
	//Step 3: Use get("key") to read values from json file.
		System.out.println(map.get("Url"));
		System.out.println(map.get("Browser"));
		System.out.println(map.get("Username"));
		System.out.println(map.get("Password"));
		System.out.println(map.get("Timeout"));
	}

}
