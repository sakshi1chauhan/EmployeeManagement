<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO"%>  
<%@page import="com.employeemanagement.model.*,java.util.*"%>
<jsp:useBean id="u" class="com.employeemanagement.model.Employee"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
Employee e=new Employee();
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
System.out.println(id);
EmpDAO ed1=new EmpDAO();
e.setEmpId(id);
int status=ed1.deleteDetail(e);  
if(status==1){
response.sendRedirect("viewemp.jsp");
}
%>  