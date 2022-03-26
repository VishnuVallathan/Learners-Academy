<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.TeacherBean" %>
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

<h3 align="center" >All Teacher Detail</h3>
<% 
List<TeacherBean> tlist=(List<TeacherBean>) request.getAttribute("listoftchrobj");
%>
<table align="center" border="1">
<th><tr>
<td>Teacher ID</td>
<td>Teacher Name</td>
<td>Teacher last name </td>

</tr>
<%for(TeacherBean tbean:tlist) { %>
<tr>
<td><%=tbean.getTid() %></td>
<td><%=tbean.getTname()%></td>
<td><%=tbean.getTlname()%></td>
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