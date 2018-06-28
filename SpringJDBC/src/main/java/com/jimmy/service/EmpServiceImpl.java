package com.jimmy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimmy.dao.EmpDAO;
import com.jimmy.model.Emp;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO empDao;
	
	@Override
	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
		
	}

	@Override
	public void updateEmp(Emp emp, int empId) {
		empDao.updateEmp(emp, empId);
		
	}

	@Override
	public void deleteEmp(int empId) {
		empDao.deleteEmp(empId);
		
	}

	@Override
	public Emp findEmp(int empId) {
		
		return empDao.findEmp(empId);
	}

	@Override
	public List<Emp> findAll() {
		
		return empDao.findAll();
	}

}
