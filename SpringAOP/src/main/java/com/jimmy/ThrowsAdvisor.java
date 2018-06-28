package com.jimmy;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdvisor implements ThrowsAdvice {
 public void afterThrowing(Exception ex) {
	 
	 System.out.println("if exception occurs "+ ex);
 }
}
