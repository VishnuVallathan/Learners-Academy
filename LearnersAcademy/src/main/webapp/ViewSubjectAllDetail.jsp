<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.LearnerAcademy.Bean.SubjectBean" %>
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

<h3 align="center" >All Subject Detail</h3>
<% 
List<SubjectBean> sblist=(List<SubjectBean>) request.getAttribute("listofsubjobj");
%>
<table align="center" border="1">
<th><tr>
<td>Subbject ID</td>
<td>Subject Name</td>
</tr>
<%for(SubjectBean sbbean:sblist) { %>
<tr>
<td><%=sbbean.getSbid() %></td>
<td><%=sbbean.getSbname()%></td>
<td><a href="AddSubjectView.html" >Edit</a></td>
<td><a href="DeleteSubject.html" >Delete</a></td>

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