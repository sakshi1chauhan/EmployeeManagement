package com.employee_management.employeeDAOimplementation;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.employeemanagement.model.Employee;

public class EmpDAOTest extends EmpDAO {

	@Test
	public void testInsertDetail() {
	    Employee e=new Employee();
		e.setEmpId(1112);
		e.setEmpContact("9876543210");
		e.setEmpName("smita");
		e.setEmpAddress("87hhkfhsf");
		e.setSalary(8900);
		e.setProId(98);
		e.setProDesc("rrsrtts");
		EmpDAO empdao=new EmpDAO();
		int st=empdao.insertDetail(e);
		assertEquals(4,st);
	}

	@Test
	public void testShowDetails() {
			
	}

	@Test
	public void testSortRecord() {
		
	}

	@Test
	public void testUpdateSalary() {
		Employee e=new Employee();
		e.setSalary(9900);
		e.setEmpId(1111);
		EmpDAO empdao=new EmpDAO();
		int st=empdao.updateSalary(e);
		assertEquals(1,st);
	}

	@Test
	public void testUpdateProject() {
	     Employee e=new Employee();
	     e.setProId(99);
		 e.setProDesc("abcdefgh");
		 EmpDAO empdao=new EmpDAO();
		 int st=empdao.updateProject(e);
		 assertEquals(1,st);
			}

	@Test
	public void testAssignProject() {
		 Employee e=new Employee();
	     e.setEmpId(1);
		 e.setProId(99);
		 EmpDAO empdao=new EmpDAO();
		 int st=empdao.assignProject(e);
		 assertEquals(1,st);
	}

	@Test
	public void testUpdateDetail() {
		 Employee e=new Employee();
	     e.setEmpContact("888888");
		 e.setEmpName("smita");
		 EmpDAO empdao=new EmpDAO();
		 int st=empdao.updateDetail(e);
		 assertEquals(1,st);
	}

	@Test
	public void testCountEmpOnProject() {
		
	}

	@Test
	public void testDeleteDetail() {
		 Employee e=new Employee();
	     e.setEmpId(12);
	      EmpDAO empdao=new EmpDAO();
		 int st=empdao.deleteDetail(e);
		 assertEquals(1,st);
	}

	@Test
	public void testFindRecord() {
		Employee e=new Employee();
		e.setEmpId(12);
		EmpDAO empdao=new EmpDAO();
		List<Employee> list=new ArrayList<Employee>();
		e.setEmpId(1112);
		e.setEmpContact("9876543210");
		e.setEmpName("smita");
		e.setEmpAddress("87hhkfhsf");
		e.setSalary(8900);
		e.setProId(98);
		e.setProDesc("rrsrtts");
		list.add(e);
		assertEquals(list.get(0).getEmpId(),empdao.findRecord(e).get(0).getEmpId());
	}

}
