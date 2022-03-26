<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.TeacherBean" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form  action="AdminServlet" method="get">
<div  style ="background-color:pink ;height:400px;width:300px;float:left;margin:20px;border-color:red;border-width:4px;border-style:solid;">

<h3 align="center" >Teacher Detail</h3>
<% 
TeacherBean tbean=(TeacherBean) request.getAttribute("tchrobj");
%>
<table align="center">
<hr>
<tr><td>Teacher ID:</td>
<td><%=tbean.getTid()%></td></tr>

<tr><td>Teacher Name:</td>
<td><%=tbean.getTname()%></td></tr>

<tr><td>Teacher Last Name:</td>
<td><%=tbean.getTlname()%></td></tr>
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