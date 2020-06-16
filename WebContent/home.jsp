<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Retail Bank </h2>
<%  String ids=(String)session.getAttribute("name"); %>
<h3 id="msg">Welcome <%=ids%></h3>

<a href="BankController?action=showCustomer" > Show Customer</a>
<a href="updateCustomer.jsp" name="editCustomer">Update Profile</a>
<a href="BankController?action=Logout" > Logout</a>

</body>
</html>