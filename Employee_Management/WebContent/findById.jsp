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
Employee e=new Employee();
EmpDAO ed1=new EmpDAO();
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
e.setEmpId(id);
List<Employee> list=ed1.findRecord(e);
request.setAttribute("list",list);

%>
<table border="1" width="70%">
<tr><th>Id</th><th>Contact</th><th>Name</th><th>Address</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getEmpId()}</td><td>${u.getEmpContact()}</td><td>${u.getEmpName()}</td><td>${u.getEmpAddress()}</td>
	</tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>


