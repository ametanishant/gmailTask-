package com.nishant.selenium;

import java.util.Random;

public class Resources {
	
	
	
	public static String genrateRandomNumber() {


          Random rand = new Random();

          int  n = rand.nextInt(50000000) + 1;
          
          String value = Integer.toString(n);
		  return value;
          
          
	}
	
	

}
