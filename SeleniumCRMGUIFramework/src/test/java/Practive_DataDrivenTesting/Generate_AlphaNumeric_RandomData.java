package Practive_DataDrivenTesting;

import java.util.Random;

public class Generate_AlphaNumeric_RandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// mention length of AlphaNumeric data
		int n=20;
		
// Choose a character randomly from this String
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
// Create StringBuffer size of AlphaNumericString
		StringBuffer sb=new StringBuffer(n);
	
		for (int i=0;i<n;i++) {

		// Generate Random Number between 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length()*Math.random());
			
		// Add characater one by one in end of sb variable.
			sb.append(AlphaNumericString.charAt(index));
			
		}
		System.out.println(sb);
	}

}
