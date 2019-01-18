<body>

<%@page import="com.employee_management.employeeDAOimplementation.EmpDAO,
                com.employeemanagement.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
Employee e=new Employee();
EmpDAO ed1=new EmpDAO();
String idd=request.getParameter("id");
int id=Integer.parseInt(idd);
e.setProId(id);
List<Employee> list=ed1.countEmpOnProject(e);
request.setAttribute("list",list);
%>
<table border="1" width="25%">
<tr><th>Name</th></tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getEmpName()}</td></tr>
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>