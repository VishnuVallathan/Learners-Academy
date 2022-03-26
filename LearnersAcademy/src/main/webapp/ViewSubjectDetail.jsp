<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.SubjectBean" %>
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
SubjectBean sbbean=(SubjectBean) request.getAttribute("subjobj");
%>
<table align="center">
<hr>
<tr><td>Subject ID:</td>
<td><%=sbbean.getSbid()%></td></tr>

<tr><td>Student Name:</td>
<td><%=sbbean.getSbname()%></td></tr>


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