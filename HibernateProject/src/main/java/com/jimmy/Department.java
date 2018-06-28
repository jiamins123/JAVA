package com.jimmy;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;



@Entity
@Table(name="DEPT_BATCH36_O2M")

public class Department {
 @Id
 @GeneratedValue
 @Column(name="DEPARTMENT_ID")
 private Long departmentId;
 
 @Column(name="DEPART_NAME")
 private String departmentName;
 
 @OneToMany(mappedBy="department")
 private Set<Employee2> employees;

public Long getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public Set<Employee2> getEmployees() {
	return employees;
}

public void setEmployees(Set<Employee2> employees) {
	this.employees = employees;
}
 
 
}
