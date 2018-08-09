package com.selenium.assessment;

import java.util.Random;

public class DataManager {
	
	/*
	public static void main(String []args){
		 
		DataManager dm =  new DataManager();
		String genDigit = dm.generatePhoneNubmer();
		System.out.print(genDigit);
	}*/
	
	
	public String generatePhoneNubmer() { 
	    Random rnd = new Random();
	    char [] digits = new char[9];
	    digits[0] = (char) (rnd.nextInt(9) + '1');
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    String phone = '0' + (new String(digits));
	    
	    return phoneDecorator(phone);
	}
	
	private String phoneDecorator(String phne){
		
		
        StringBuilder sb = new StringBuilder(phne)
                                .insert(0," ")
                                .insert(4," ")
                                .insert(8," ");
		
		return sb.toString();
	}

}
