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
<input type="hidden" name="searchvbn" value="delete">
Account ID: <input type="number" name="Acid">
<input type="submit" value="fetch">
</form>

<% Account cst= null; cst=(Account) request.getAttribute("class"); 
if(cst != null) {
%>
<form action="BankController?action=deleteAcc" method="post">
<input type="hidden" name="vbn" value="<%= cst.getAccountID() %>">
Account ID: <label><%=cst.getAccountID() %></label>
Customer ID: <label><%=cst.getCustomerID()%></label>
Account Type: <label><%=cst.getAccount_type() %></label>
<input type="submit" value="delete">
</form>
<% } %>
<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</body>
</html>