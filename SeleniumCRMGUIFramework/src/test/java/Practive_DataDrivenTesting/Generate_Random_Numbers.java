package Practive_DataDrivenTesting;

import java.util.Random;

public class Generate_Random_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// create object of Random class
		Random random=new Random();
		
// Set upper limit using nextInt method of random class. It's return type is int.
		int randomInt=random.nextInt(1000);
	
		System.out.println(randomInt);
	}

}
