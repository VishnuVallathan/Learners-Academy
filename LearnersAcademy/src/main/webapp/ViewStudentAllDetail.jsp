<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.StudentBean" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form  action="AdminServlet" method="get">
<div  style ="background-color:pink ;height:400px;width:500px;float:left;margin:20px;border-color:red;border-width:4px;border-style:solid;">

<h3 align="center" >All Student Detail</h3>
<% 
List<StudentBean> stlist=(List<StudentBean>) request.getAttribute("listofstudobj");
%>
<table align="center" border="1">
<th><tr>
<td>Student ID</td>
<td>student Name</td>
<td>student last name </td>
<td>class id </td>
</tr>
<%for(StudentBean stbean:stlist) { %>
<tr>
<td><%=stbean.getSid() %></td>
<td><%=stbean.getSname()%></td>
<td><%=stbean.getSlname()%></td>
<td><%=stbean.getFkclsid() %></td>
<td><a href="AddTecaherView.html" >Edit</a></td>
<td><a href="DeleteTeacher.html" >Delete</a></td>

</tr></th>
<% } %>
<hr>
<td>
<tr><a href="AdminHomepage.html">Home</a>
</tr>
<hr>

<tr><a href="logout">Logout</a></tr>
<hr>
</td>
</div>

</table>
</body>
</html>