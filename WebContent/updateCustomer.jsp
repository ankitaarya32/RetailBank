<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.BankCustomer,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankController" method="post">
<input type="radio" name="search" value="cadhar">Enter Customer Adhar:
<input type="text" name="adhar"><br>
<input type="radio" name="search" value="cid">Enter Customer ID:
<input type="text" name="CusID"><br>
<input type="submit" name="action" value="EditCustomer">
<br>
</form>

<% BankCustomer cst= null; cst=(BankCustomer) request.getAttribute("class"); 
if(cst != null) {
%>
<form action="BankController" method="post">
<input type="hidden" name="vbn" value="<%= cst.getCustomerId() %>">
Customer Adhar: <label><%= cst.getCustomerAdhar() %></label><br>
Customer ID: <label><%=cst.getCustomerId() %></label><br>
Old Customer Name: <label><%=cst.getCustomer_name() %></label><br>
New Customer Name: <input type="text" name="Cname"><br>
Old Address: <label><%=cst.getAddress() %></label><br>
New Address: <input type="text" name="Caddress"><br>
Old Age: <label><%=cst.getAge() %></label><br>
New Age: <input type="text" name="Cage"><br>
<input type="submit" name="action" value="UpdateCustomer">
</form>
<% } %>

<% String smsg=(String)request.getAttribute("smsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</body>
</html>