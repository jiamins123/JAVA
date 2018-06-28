package com.jimmy;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {
	
@SuppressWarnings("unchecked")
public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session =sf.openSession();
	EmployeeDetail employeeDetail =new EmployeeDetail("1124 highfield ct","Bethel Park","Pa","USA");
	Employee employee =new Employee("Dev", "Andand", new Date(10-10-10),"114-222-333");
	employee.setEmployeeDetail(employeeDetail);
	employeeDetail.setEmployee(employee);
session.beginTransaction();
System.out.println("before save");
session.save(employee);
Query<Employee> query = session.createQuery("from Employee");
@SuppressWarnings("deprecation")
List<Employee> employees= query.getResultList();
for(Employee e1:employees) {
System.out.println(e1.getFirstname()+" , "+e1.getLastname()+" , "+ e1.getEmployeeDetail().getStreet()+" , "+e1.getEmployeeDetail().getCity()+" , "+
e1.getEmployeeDetail().getState()+e1.getEmployeeDetail().getCountry());
}	
System.out.println("after save");
session.getTransaction().commit();
session.close();
}	
}
