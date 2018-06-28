package com.jimmy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jimmy.model.Emp;

@Repository

public class EmpDAOImpl implements EmpDAO {
    @Autowired
	 JdbcTemplate jdbcTemplate; 
	@Override
	public void addEmp(Emp emp) {
	
		jdbcTemplate.update("insert into emp_batch36 values(?,?,?)",emp.getEmpId(),emp.getEmpName(),emp.getEmpSal());
		
		System.out.println("Emp inserted");
	}

	@Override
	public void updateEmp(Emp emp, int empId) {
		jdbcTemplate.update("update emp_batch36 set ename=? ,esal=? where eno=?",emp.getEmpName(),emp.getEmpSal(),empId);
		
		System.out.println("Emp updated");
	}

	@Override
	public void deleteEmp(int empId) {
		jdbcTemplate.update("delete from emp_batch36 where eno=?",empId);
		System.out.println("Emp deleted");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Emp findEmp(int empId) {
		
		return jdbcTemplate.queryForObject("select * from emp_batch36 where eno=?"
			,new Object[]{empId},new RowMapper<Emp>() {
				@Override
			public Emp mapRow(ResultSet rs ,int rowNumber ) throws SQLException{
				Emp e = new Emp();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpSal(rs.getDouble(3));
		  	     return e;
			}
			
	});
}
	@Override
	public List<Emp> findAll() {
		return jdbcTemplate.query("select * from emp_batch36", new RowMapper<Emp>() {
			@Override
			public Emp mapRow(ResultSet rs, int rowNumber) throws SQLException{
				Emp e =new Emp();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpSal(rs.getDouble(3));
				return e;
				
			}
		});
	}

}
