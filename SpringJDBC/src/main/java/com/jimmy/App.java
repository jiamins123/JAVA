package com.jimmy;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jimmy.config.AppConfig;
import com.jimmy.model.Emp;
import com.jimmy.service.EmpService;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
                AppConfig.class);
    	EmpService empService =(EmpService) ctx.getBean("empService");
    	Emp e1 =new Emp(1007,"Dev",12345.0);
    	Emp e2 =new Emp(1008,"Barath",12345.0);
    	Emp e3 =new Emp(1009,"Jason",12345.0);
    	
    	empService.addEmp(e1);
    	empService.addEmp(e2);
    	empService.addEmp(e3);
    	
    	System.out.println("Retreive all employees");
    	List <Emp> emps =empService.findAll();
    	emps.forEach(System.out::println);
    
    	System.out.println("Retreive employees based on Id=1007");
    	Emp e4=empService.findEmp(1007);
    System.out.println(e4);
    	
    
	System.out.println("Update employees based on Id=1007");
	int empUpdate=1007;
	e1.setEmpName("Jimmy");
	e1.setEmpSal(13333.0);
	empService.updateEmp(e1, 1007);
    System.out.println(e1);
   
    System.out.println("delete employees based on Id=1008");
	int empDelete=1008;
	empService.deleteEmp(empDelete);
    
	emps=empService.findAll();
	emps.forEach(System.out::println);
    
    ctx.close();
    }
}
