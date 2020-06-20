<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.BankCustomer,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{background-color:yellow;font-size:22px;}
td{background-color:white;font-size:22px;}
</style>
<%  String pageTitle="Customer Status";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
</head>
<body>
<center>

<h1>Customer Status</h1>
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
<td><a href="BankController?action=showCustomer">Refresh</a></td>

</tr>


<% } %>
</table>
</center>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>