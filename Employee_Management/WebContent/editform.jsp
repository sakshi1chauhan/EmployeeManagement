<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,com.employeemanagement.model.Employee"%>  
  
<%  
String id=request.getParameter("id");  
EmpDAO empdao=new EmpDAO();
empdao.updateDetail(Integer.parseInt(id));  
Employee e=new Employee();
%>  
  
<h1>Edit Form</h1>  
<form action="editemp.jsp" method="post">  
<input type="hidden" name="id" value="<%=e.getEmpId() %>"/>  
<table>
<tr><td>Contact</td><td>  
<input type="text" name="contact" value="<%= e.getEmpContact()%>"/></td></tr>   
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= e.getEmpName()%>"/></td></tr>  
<tr><td>Address</td><td>  
<input type="text" name="address" value="<%= e.getEmpAddress()%>"/></td></tr>  
<tr><td>Salary</td><td>  
<input type="text" name="salary" value="<%= e.getSalary()%>"/></td></tr>  
 <tr><td>Project Id</td><td>  
<input type="text" name="pid" value="<%= e.getProId()%>"/></td></tr> 
<tr><td>Project Description:</td><td>  
<input type="text" name="desc" value="<%= e.getProDesc()%>"/></td></tr> 
 
<tr><td colspan="2"><input type="submit" value="Edit Employee"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  