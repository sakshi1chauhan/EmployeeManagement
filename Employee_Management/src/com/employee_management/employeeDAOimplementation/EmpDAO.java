package com.employee_management.employeeDAOimplementation;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee_management.employeeDAO.DBConnection;
import com.employee_management.employeeDAO.EmployeeOperations;
import com.employeemanagement.model.Employee;
import com.employeemanagement.model.Employee1;



public class EmpDAO implements EmployeeOperations{
	
	
	@Override
	public int insertDetail(Employee e) {
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
		System.out.println("Connection= "+ con);
		
		int status=0;  
        try{  
             
            PreparedStatement ps=con.prepareStatement("insert into emp (EmpId,EmpContact,EmpName,EmpAddress) values (?,?,?,?)");  
            ps.setInt(1,e.getEmpId());  
            ps.setString(2,e.getEmpContact()); 
            ps.setString(3,e.getEmpName());  
            ps.setString(4,e.getEmpAddress());  
            ps.executeUpdate();
            status=1;
            
            PreparedStatement ps1=con.prepareStatement("insert into salary (Salary,EmpId) values (?,?)");  
            ps1.setInt(1,e. getSalary()); 
            ps1.setInt(2,e. getEmpId());  
            ps1.executeUpdate(); 
            status=2;
            
            PreparedStatement ps2=con.prepareStatement("insert into project (ProjectId,ProjectDescr) values (?,?)");  
            ps2.setInt(1,e. getProId());  
            ps2.setString(2,e. getProDesc()); 
            ps2.executeUpdate(); 
             status=3;
            
            PreparedStatement ps3=con.prepareStatement("insert into employee_project (EmpId,ProjectId) values (?,?)");  
            ps3.setInt(1,e. getEmpId());  
            ps3.setInt(2,e. getProId()); 
             ps3.executeUpdate(); 
            status=4;
            con.close();  
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
          return status;

	}

	@Override
	public  List<Employee> showDetails() {
		
		List<Employee> list=new ArrayList<Employee>();
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection();  
			
			PreparedStatement ps=con.prepareStatement("select * from emp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee u=new Employee();
				u.setEmpId(rs.getInt("EmpId"));
				u.setEmpContact(rs.getString("EmpContact"));
				u.setEmpName(rs.getString("EmpName"));
				u.setEmpAddress(rs.getString("EmpAddress"));
				
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
		//return null;
	}

	
	@Override
	public int deleteDetail(int id) {
		
		int status=0;
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection(); 
			PreparedStatement ps1=con.prepareStatement("delete from salary where Empid=?");
			ps1.setInt(1,id);
			status=ps1.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("delete from employee_project where Empid=?");
			ps2.setInt(1,id);
			status=ps2.executeUpdate();
			PreparedStatement ps=con.prepareStatement("delete from emp where Empid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			System.out.println("delete successful");
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
		
	}

	@Override
	public List<Employee> findRecord(int id) {
		
		List<Employee> list=new ArrayList<Employee>();
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection();  
			
			PreparedStatement ps=con.prepareStatement("select * from emp where EmpId=?");
		    ps.setInt(1,id);
		    ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee u=new Employee();
				u.setEmpId(rs.getInt("EmpId"));
		        u.setEmpContact(rs.getString("EmpContact"));
				u.setEmpName(rs.getString("EmpName"));
				u.setEmpAddress(rs.getString("EmpAddress"));
				
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	@Override
	public List<Employee> sortRecord() {
		List<Employee> list=new ArrayList<Employee>();
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection();  
			
			PreparedStatement ps=con.prepareStatement("SELECT emp.EmpContact,emp.EmpName, "
				                                    	+ "emp.EmpAddress, salary.Salary FROM "
				                                    	+ "emp INNER JOIN salary ON emp.EmpId=salary.EmpId ORDER BY Salary ASC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee u=new Employee();
				u.setEmpContact(rs.getString("EmpContact"));
				u.setEmpName(rs.getString("EmpName"));
				u.setEmpAddress(rs.getString("EmpAddress"));
				u.setSalary(rs.getInt("Salary"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
		
	}

	@Override
	public int updateSalary(Employee e) {
		int status=0;
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
		
		try {
				PreparedStatement ps = con.prepareStatement("update salary set Salary=? where EmpId=?");
				System.out.println("hellooooo"+ e.getSalary() +"hellooooo");
		        ps.setInt(1,e.getSalary());
		        ps.setInt(2,e.getEmpId()); 
                ps.executeUpdate(); 
                status=1;
                System.out.println(" Salary Updated"+status);
               	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}  
			return status;
		
	}

	@Override
	public int updateProject(Employee e) {
		int status=0;
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
				try {
				PreparedStatement ps = con.prepareStatement("update project set ProjectDescr=? where ProjectId=?");
		        ps.setString(1,e.getProDesc());
		        ps.setInt(2,e.getProId()); 
		      
                ps.executeUpdate(); 
                status=1;
                System.out.println("Project Updated"+status);
               	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}  
			return status;
		
	}

	public int assignProject(Employee e) {
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
		System.out.println("Connection= "+ con);
		
		int status=0;  
        try{  
             
            PreparedStatement ps=con.prepareStatement("insert into employee_project (EmpId,ProjectId) values (?,?)");  
            ps.setInt(1,e.getEmpId());  
            ps.setInt(2,e.getProId()); 
            ps.executeUpdate();
            status=1;
		    con.close();  
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
          return status;
	}

	@Override
	public int updateDetail(Employee e) {
         int status=0;
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
		
			try {
				 PreparedStatement ps = con.prepareStatement("update emp set EmpContact=?,EmpName=?,EmpAddress=? where EmpId=?");
		        ps.setString(1,e.getEmpContact()); 
                ps.setString(2,e.getEmpName());  
                ps.setString(3,e.getEmpAddress());  
                ps.setInt(4,e.getEmpId());  
                ps.executeUpdate(); 
                status=1;
                System.out.println("Update"+status);
               	} catch (SQLException e1) {
		        e1.printStackTrace();
	          }  
			return status;
		
	}

	@Override
	public List<Employee> countEmpOnProject(Employee e) {
		List<Employee> list=new ArrayList<Employee>();
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection();  
			PreparedStatement ps=con.prepareStatement("SELECT emp.EmpName  FROM emp INNER JOIN employee_project"
				                                    	+ " ON emp.EmpId=employee_project.EmpId where ProjectId=?;");
			ps.setInt(1,e.getProId()); 
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				//e.setProId(rs.getInt("ProjectId"));
				e.setEmpName(rs.getString("EmpName"));
				list.add(e);
			}
		}catch(Exception e1){System.out.println(e1);}
		return list;
	}

	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
    
}
