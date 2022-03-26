<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.ClassBean" %>
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

<h3 align="center" >AllClass Detail</h3>
<% 
List<ClassBean> list=(List<ClassBean>) request.getAttribute("listofclobj");
%>
<table align="center" border="1">
<th><tr>
<td>Class ID</td>
<td>Class Name</td>
<td>Class time</td>
<td>Subject Id</td>
<td>teacher Id</td>

</tr>
<%for(ClassBean bean:list) { %>
<tr>
<td><%=bean.getClid() %></td>
<td><%=bean.getClname()%></td>
<td><%=bean.getClasstime()%></td>
<td><%=bean.getFksbid()%></td>
<td><%=bean.getFktchrid() %></td>
<td><a href="AddClassView.html" >Edit</a></td>
<td><a href="DeleteClass.html" >Delete</a></td>

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