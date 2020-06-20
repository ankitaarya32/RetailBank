<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<%  String pageTitle="Search Customer";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style>
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 3px solid #f1f1f1;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 80%;
  padding: 20px;
  text-align: center;
}
</style>
</head>
<body>
<div class="bg-text">
<center>
<h3>Search Customer</h3>
<form action="BankController" method="post">
<input type="radio" name="search" value="cadhar" required>Enter Customer Adhar:
<input type="text" name="adhar" ><br>
<h4> --or--</h4>
<input type="radio" name="search" value="cid">Enter Customer ID:
<input type="text" name="CusID" ><br><br>
<input type="submit" name="action" value="SearchCustomer" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
<br>
</form>
<% List<Integer> l1=(List<Integer>) request.getAttribute("class");
//cst=(Account) request.getAttribute("class");
Account acc= null; 

if(l1 != null) {
	
%>
<form action="BankController?action=secc" method="post">
<br>
<h4>Account ID</h4>
<select name="accid">
<% for(int x:l1){  %>

<option><%=x %></option>

<% }%>
</select>
<input type="submit" value="Submit">
</form>
<%}%>

<% 
String bal=(String) request.getAttribute("geterm");
System.out.print(bal);
if(bal != null){ %>
<h3>No Accounts Found</h3>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>