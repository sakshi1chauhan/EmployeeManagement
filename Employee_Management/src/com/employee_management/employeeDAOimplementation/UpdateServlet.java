/*
 *  UpdateServlet 
 * 
 * Version 1.0
 *
 * 2019-01-16
 * 
 * Copyright notice
 */
package com.employee_management.employeeDAOimplementation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanagement.model.Employee;
import com.employeemanagement.model.Employee1;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String idn=request.getParameter("id");
		String contact=request.getParameter("contact");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		Employee e=new Employee();
		 EmpDAO empdao=new EmpDAO();
		int id=Integer.parseInt(idn);
		e.setEmpId(id);
		e.setEmpContact(contact);
		e.setEmpName(name);
		e.setEmpAddress(address);
		System.out.println(id);
		int status=empdao.updateDetail(e);  
		System.out.println("update succesful");
		if(status==1){
			response.sendRedirect("viewemp.jsp");  
			}else{
				response.sendRedirect("ERROR.jsp");
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
