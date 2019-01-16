package com.employee_management.employeeDAOimplementation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagement.model.Employee;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String idd=request.getParameter("id");
		int id=Integer.parseInt(idd);
		System.out.println(id);
		String contac=request.getParameter("contact");
		int contact=Integer.parseInt(contac);
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String sal=request.getParameter("salary");
		int salary=Integer.parseInt(sal);
		String project=request.getParameter("pid");
		int projectId=Integer.parseInt(project);
		String projectDescr=request.getParameter("prodesc");
		Employee e=new Employee();
		
		e.setEmpId(id);
		e.setEmpContact(contact);
		e.setEmpName(name);
		e.setEmpAddress(address);
		e.setSalary(salary);
		e.setProId(projectId);
		e.setProDesc(projectDescr);
		
		EmpDAO e1=new EmpDAO();
		int status=e1.insertDetail(e);
		 if(status==4){
   		  response.sendRedirect("addemp-success.jsp");  
          System.out.println("Record Inserted");
         }else{
       	  response.sendRedirect("addemp-error.jsp"); 
         }
		//request.getRequestDispatcher("addemp.jsp").include(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
