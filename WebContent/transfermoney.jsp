<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankController?action=transfer" method="post">
Source Account : <input type="number" name="Sacc">
Target Account: <input type="number" name="Tacc">
Transfer Amount: <input type="number" name="Tamo">
<input type="submit" value="Submit">
</form>

<% String smsg=(String)request.getAttribute("transBal"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
<% String smsg2=(String)request.getAttribute("rsms"); if(smsg2 != null) { %>
<h3><%=smsg2 %></h3>
<% } %>
</body>
</html>