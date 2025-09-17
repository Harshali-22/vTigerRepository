package Practive_DataDrivenTesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {

	@Test
	public void runtimeParameterTest() {
		
		String url=System.getProperty("Url");
		String browser=System.getProperty("Browser");
		String username=System.getProperty("Username");
		String pwd=System.getProperty("Password");
		
		System.out.println("Environment data====> URL====>"+url);
		System.out.println("Environment data====> Browser====>"+browser);
		System.out.println("Environment data====> Username====>"+username);
		System.out.println("Environment data====> Password====>"+pwd);
	}
}
