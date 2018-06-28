package com.jimmy.service;


import java.util.List;

import com.jimmy.model.Emp;

public interface EmpService {
  public void addEmp(Emp emp);
  public void updateEmp(Emp emp,int empId);
  public void deleteEmp(int empId);
  public Emp findEmp(int empId);
  public List<Emp> findAll();
}
