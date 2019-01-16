<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO"%>  
<jsp:useBean id="u" class="com.employeemanagement.model.Employee"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
EmpDAO empdao1=new EmpDAO();
int status=empdao1.updateDetail(id);  
if(status==1){
response.sendRedirect("viewemp.jsp");  
}%>  