package com.employee_management.employeeDAO;

import java.util.List;

import com.employeemanagement.model.Employee;

public interface EmployeeOperations {

	public int insertDetail(Employee e) ;
	public List<Employee> showDetails();
	public int updateDetail(int id);
	public int deleteDetail(int id);
	public List<Employee> findRecord(int id);
	public void sortRecord();
	public void countEmpOnProject(int pid);
	
}
