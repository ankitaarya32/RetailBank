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
<form action="BankController?action=searchCust" method="post">
Customer ID: <input type="number" name="CID">
<input type="submit" value="fetch">
</form>

<% BankCustomer cst= null; cst=(BankCustomer) request.getAttribute("class"); 
if(cst != null) {
%>
<form action="BankController?action=deleteCust" method="post">
<input type="hidden" name="vbn" value="<%= cst.getCustomerId() %>">
Customer ID: <label><%=cst.getCustomerId() %></label>
Customer Adhar: <label><%= cst.getCustomerAdhar() %></label><br>
Customer Name: <label><%=cst.getCustomer_name() %></label>
Address: <label><%=cst.getAddress() %></label>
Age: <label><%=cst.getAge() %></label>
<input type="submit" value="delete">
</form>
<% } %>
<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</body>
</html>