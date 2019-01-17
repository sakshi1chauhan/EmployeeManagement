package com.employee_management.employeeDAO;

import java.util.List;

import com.employeemanagement.model.Employee;

public interface EmployeeOperations {

	public int insertDetail(Employee e) ;
	public List<Employee> showDetails();
	public int updateDetail(Employee e);
	public int deleteDetail(int id);
	public List<Employee> findRecord(int id);
	public List<Employee> sortRecord();
	public List<Employee> countEmpOnProject(Employee e);
	public int updateSalary(Employee e);
	public int updateProject(Employee e);
	
}
