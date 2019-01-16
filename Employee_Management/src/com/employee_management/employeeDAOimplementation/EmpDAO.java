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
            ps.setInt(2,e.getEmpContact()); 
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
				u.setEmpContact(rs.getInt("EmpContact"));
				u.setEmpName(rs.getString("EmpName"));
				u.setEmpAddress(rs.getString("EmpAddress"));
				
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
		//return null;
	}

	@Override
	public int updateDetail(int id) {
		int status=0;
		
		DBConnection DBCON=new DBConnection();
		Connection con=DBCON.getConnection();  
		
		Employee e=new Employee();
		
           
			try {
				 PreparedStatement ps = con.prepareStatement("update emp set EmpContact=?,EmpName=?,EmpAddress=? where EmpId=?");
		        ps.setInt(1,e.getEmpContact()); 
                ps.setString(2,e.getEmpName());  
                ps.setString(3,e.getEmpAddress());  
                ps.setInt(4,id);  
                ps.executeUpdate(); 
                status=1;
                
               	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}  
			return status;
	}
	@Override
	public int deleteDetail(int id) {
		
		int status=0;
		try{
			DBConnection DBCON=new DBConnection();
			Connection con=DBCON.getConnection();  
			PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
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
			ResultSet rs=ps.executeQuery();
			ps.setInt(1,id);
			
			while(rs.next()){
				Employee u=new Employee();
		        u.setEmpContact(rs.getInt("EmpContact"));
				u.setEmpName(rs.getString("EmpName"));
				u.setEmpAddress(rs.getString("EmpAddress"));
				
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}

	@Override
	public void sortRecord() {
	
		
	}

	@Override
	public void countEmpOnProject(int pid) {
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}
