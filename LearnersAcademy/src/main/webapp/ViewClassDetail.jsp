<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.ClassBean" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form  action="AdminServlet" method="get">
<div  style ="background-color:pink ;height:400px;width:300px;float:left;margin:20px;border-color:red;border-width:4px;border-style:solid;">

<h3 align="center" >Class Detail</h3>
<% 
ClassBean bean=(ClassBean) request.getAttribute("clobj");
%>
<table align="center">
<hr>
<tr><td>Class ID:</td>
<td><%=bean.getClid() %></td></tr>

<tr><td>Class Name:</td>
<td><%=bean.getClname()%></td></tr>

<tr><td>Class time:</td>
<td><%=bean.getClasstime()%></td></tr>

<tr><td>Subject Id:</td>
<td><%=bean.getFksbid()%></td></tr>

<tr><td>teacher Id:</td>
<td><%=bean.getFktchrid() %></td></tr>
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