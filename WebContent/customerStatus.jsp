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
<table border="1">
<tr>
<th>Customer ID</th>
<th>Customer Adhar</th>
<th>Status</th>
<th>Message</th>
<th>Last Updated</th>
<th>Operation</th>
</tr>
<% List<BankCustomer> cust=(List<BankCustomer>) request.getAttribute("listcust"); 
for(BankCustomer x:cust) {
%>
<tr>
<td><%=x.getCustomerId() %></td>
<td><%=x.getCustomerAdhar() %></td>
<td><%=x.getStatus() %></td>
<td><%=x.getMessage() %></td>
<td><%=x.getLast_update() %></td>

</tr>


<% } %>
</table>
</body>
</html>