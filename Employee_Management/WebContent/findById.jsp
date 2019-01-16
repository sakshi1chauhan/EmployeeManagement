<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search By Id</title>
</head>
<body>

<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,com.employeemanagement.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Search By Id</h1>

<%
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
EmpDAO ed1=new EmpDAO();
List<Employee> list=ed1.findRecord(id);
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>Id</th><th>Contact</th><th>Name</th>
    <th>Address</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getEmpId()}</td><td>${u.getEmpContact()}</td><td>${u.getEmpName()}</td>
	    <td>${u.getEmpAddress()}</td>
	    <td><a href="editform.jsp?id=${u.getEmpId()}">Edit</a></td>
	   
	</tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>l>