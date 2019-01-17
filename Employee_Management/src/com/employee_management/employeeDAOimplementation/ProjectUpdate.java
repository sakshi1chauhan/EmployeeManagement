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
 * Servlet implementation class ProjectUpdate
 */
@WebServlet("/ProjectUpdate")
public class ProjectUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String idn=request.getParameter("pid");
		int id=Integer.parseInt(idn);
		String ProjectDesc=request.getParameter("pdesc");
		Employee e=new Employee();
		EmpDAO empdao=new EmpDAO();
		e.setProId(id);
		e.setProDesc(ProjectDesc);
		System.out.println(id+" "+ProjectDesc);
		int status=empdao.updateProject(e);  
		System.out.println("update succesful");
		if(status==1){
			response.sendRedirect("viewemp.jsp");  
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
