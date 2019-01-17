<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO"%>  
<jsp:useBean id="u" class="com.employeemanagement.model.Employee"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
System.out.println(id);
EmpDAO ed1=new EmpDAO();
int status=ed1.deleteDetail(id);  
if(status==1){
response.sendRedirect("viewemp.jsp");
}
%>  