<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
th{background-color:yellow;font-size:22px;}
td{background-color:white;font-size:22px;}
</style>
<%  String pageTitle="Account Status";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
</head>
<body>
<center>
<h1>Account Status</h1>
<table border="1">
<tr>
<th>Customer ID</th>
<th>Account ID</th>
<th>Account Type</th>
<th>Status</th>
<th>Message</th>
<th>Last Updated</th>
<th>Operation</th>
</tr>
<% List<Account> cust=(List<Account>) request.getAttribute("listcust"); 
for(Account x:cust) {
%>
<tr>
<td><%=x.getCustomerID() %></td>
<td><%=x.getAccountID() %>
<td><%=x.getAccount_type() %></td>
<td><%=x.getStatus() %></td>
<td><%=x.getMessage() %></td>
<td><%=x.getLast_updated() %></td>
<td><a href="BankController?action=showAccount">Refresh</a></td>

</tr>


<% } %>
</table>


</center>

<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>