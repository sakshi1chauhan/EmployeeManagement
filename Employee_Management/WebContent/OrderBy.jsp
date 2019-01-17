<body>

<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,
                com.employeemanagement.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
EmpDAO ed1=new EmpDAO();
List<Employee> list=ed1.sortRecord();
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>Contact</th><th>Name</th><th>Address</th>
    <th>Salary</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getEmpContact()}</td><td>${u.getEmpName()}</td>
	    <td>${u.getEmpAddress()}</td><td>${u.getSalary()}</td>
	    
	</tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>