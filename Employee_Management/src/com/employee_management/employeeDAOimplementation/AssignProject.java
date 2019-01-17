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
 * Servlet implementation class AssignProject
 */
@WebServlet("/AssignProject")
public class AssignProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignProject() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String idn=request.getParameter("id");
		int id=Integer.parseInt(idn);
		String pid=request.getParameter("pid");
		int prid=Integer.parseInt(pid);
		Employee e=new Employee();
		EmpDAO empdao=new EmpDAO();
		e.setEmpId(id);
		e.setProId(prid);
		System.out.println(id+" "+prid);
		int status=empdao.assignProject(e);  
		System.out.println("update succesful");
		if(status==1){
			response.sendRedirect("viewemp.jsp");  
			}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
