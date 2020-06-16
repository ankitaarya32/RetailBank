<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankController" method="post">
<input type="text" name="username" placeholder="username"><br>
<input type="password" name="password" placeholder="password"><br>
<input type="submit" name="action" value="execLogin">
</form>

<%  String ids=(String)request.getAttribute("ermsg"); %>
  <% if(ids!=null){ %>
<h3 id="msg"><%=ids%></h3>
<% } %> 
</body>
</html>