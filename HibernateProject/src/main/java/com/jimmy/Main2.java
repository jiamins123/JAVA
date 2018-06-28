package com.jimmy;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main2 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        
        Department department=new Department();
        department.setDepartmentName("Math");
        session.save(department);
        Department department2=new Department();
        department2.setDepartmentName("computer science");
        session.save(department2);
        
        
        Employee2 emp1=new Employee2("Dev","Andand","114-857-922");
        Employee2 emp2=new Employee2("jason","kou","615-857-922");
        emp1.setDepartment(department);
        emp2.setDepartment(department);
        emp1.setDepartment(department2);
        emp2.setDepartment(department2);
        session.beginTransaction();
        System.out.println("before save");
        session.save(emp1);
        session.save(emp2);
        System.out.println("after save");
        session.getTransaction().commit();
        Query<Employee2> query=session.createQuery("from Employee2");
        List<Employee2> employees=query.getResultList();
        System.out.print("------");
        for(Employee2 e:employees){
            System.out.println(e.getFirstname()+","+e.getLastname()+","+e.getCellphone());
        }
        session.close();
    }
}