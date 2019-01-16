package com.employee_management.employeeDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection(){  
		Connection con=null; 
        try{  
        	
        	Class.forName("com.mysql.jdbc.Driver");  
        	 con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/employee","root","root");  
        	boolean status= con.isClosed();
        	System.out.println(status);
        }
        catch(Exception e){
        	System.out.println(e);
        	}  
        return con;  
    }
}
