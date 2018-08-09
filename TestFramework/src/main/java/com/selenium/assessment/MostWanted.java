package com.selenium.assessment;

public class MostWanted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// most frequest number in an array 
		  int[] myArr = {1,40,2,3,4,2,2,30};
		  
		  int freqElement = 0 ; // nothing yet
		  int count = 0; //number of time it appears
		   for(int j=0 ;j<myArr.length;j++){
		      int tempElement = myArr[j] ; //element being explored
			  int tempCount = 0;
			  for(int x =0 ; x<myArr.length;x++){
			    if(myArr[x]==tempElement){
				  tempCount++;
				}
				if(tempCount>count){
				    freqElement =  tempElement;
					count = tempCount;
				}
			  }
			  	   
		   }
		  System.out.println("The most frequent Element is :  "+freqElement+ " Appears :"+count+"  times");

	}

}
