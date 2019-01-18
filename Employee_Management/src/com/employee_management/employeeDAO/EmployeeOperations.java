/*
 * interface EmployeeOperations 
 * 
 * Version 1.0
 *
 * 2019-01-16
 * 
 * Copyright notice
 */
package com.employee_management.employeeDAO;
import java.util.List;
import com.employeemanagement.model.Employee;

public interface EmployeeOperations {

	public int insertDetail(Employee e) ;                      //insert details
	public List<Employee> showDetails();                       //show details
	public int updateDetail(Employee e);                       //update details  
	public int deleteDetail(Employee e);                       //detail details
	public List<Employee> findRecord(Employee e);              //find record
	public List<Employee> sortRecord();                        //sort detail
	public List<Employee> countEmpOnProject(Employee e);       //count employee on project
	public int updateSalary(Employee e);                       //update salary
	public int updateProject(Employee e);                      //update Project
	
}
