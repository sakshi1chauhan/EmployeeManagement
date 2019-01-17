<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,
                com.employeemanagement.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
EmpDAO ed1=new EmpDAO();
List<Employee> list=ed1.showDetails();
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
	    <td><a href="deleteemp.jsp?id=${u.getEmpId()}">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>