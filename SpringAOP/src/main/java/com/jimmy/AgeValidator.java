package com.jimmy;

public class AgeValidator {
  public void validate (int age) throws Exception{
	   if (age < 25) {
		   throw new NullPointerException("Not a valid Age for auto insurance");
		   
	   }
	   else {
		   
		   System.out.println("valid age");
	   }
  }
}
