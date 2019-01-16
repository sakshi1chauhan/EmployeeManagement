package com.employeemanagement.model;

public class Employee {
   private int empId;
    private int empContact;
	private String empName;
	private String empAddress;
	private int salary;
	private int proId;
	public String proDesc;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int id) {
		this.empId = id;
	}
	public int getEmpContact() {
		return empContact;
	}
	public void setEmpContact(int empContact) {
		this.empContact = empContact;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String employeeName) {
		this.empName = employeeName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
}
