<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,com.employeemanagement.model.Employee"%>  
  

  
<h1>Edit Form</h1>  
<form action="UpdateServlet">  

<table>
<tr><td>Id</td><td>  
<input type="text" name="id" value=" "/></td></tr>   
<tr><td>Contact</td><td>  
<input type="text" name="contact" value=" "/></td></tr>   
<tr><td>Name:</td><td>  
<input type="text" name="name" value=""/></td></tr>  
<tr><td>Address</td><td>  
<input type="text" name="address" value=""/></td></tr>  
 
<tr><td colspan="2"><input type="submit" value="Edit Employee"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  