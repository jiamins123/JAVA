package com.jimmy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	
	public static void main (String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		 Employee e = factory.getBean("proxy2",Employee.class);
		 Employee a1 = (Employee) factory.getBean("proxy2");
		 a1.printEmp();
		 
	}
}
