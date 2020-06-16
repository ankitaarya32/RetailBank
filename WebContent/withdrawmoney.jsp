<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankController?action=searchAcc" method="post">
<input type="hidden" name="searchvbn" value="withdraw">
Account ID: <input type="number" name="Acid">
<input type="submit" value="fetch">
</form>

<% Account cst= null; cst=(Account) request.getAttribute("class");
Account acc= null; 
String bal=(String) request.getAttribute("witBal");

acc=(Account) request.getAttribute("setdep"); 
if(cst != null) {
%>
<form action="BankController?action=witBalance" method="post">
<input type="hidden" name="vbn" value="<%= cst.getAccountID() %>">
Customer ID: <label><%=cst.getCustomerID()%></label>
Account ID: <label><%=cst.getAccountID() %></label>
Account Type: <label><%=cst.getAccount_type() %></label>
Balance: <label><%=cst.getAmount() %></label>
Withdraw Balance: <input type="number" name="WeBal">
<input type="submit" value="Submit">
</form>
<% } %>

<% 
if(acc != null) {
%>
Customer ID: <label><%=acc.getCustomerID() %></label>
Account ID : <label><%=acc.getAccountID() %></label>
Balance before deposit :<label><%=bal %></label>
Latest balance : <label><%=acc.getAmount() %></label>
<h3>Amount deposited successfully</h3>
<% } %>

<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>

<% String smsg2=(String)request.getAttribute("rsms"); if(smsg2 != null) { %>
<h3><%=smsg2 %></h3>
<% } %>
</body>
</html>