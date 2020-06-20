<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Deposit Money";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style>
body,html {
  height: 100%;
  margin: 0;
  font-family: garamond, Helvetica, sans-serif;  
}
* {
  box-sizing: border-box;
}
.bg-image {
  /* The image used */
  background-image: url("image/ankit5.jpg");

  /* Add the blur effect */
  /*filter: blur(2px);
  /*-webkit-filter: blur(2px);*/
  opacity:0.5;

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
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
     <div class="bg-image"></div>
      <div class="bg-text">
<center>
<table>
<tr><th colspan="2">
<h1>Deposit Money</h1></th></tr>
<% Account cst= null; 
cst=(Account) session.getAttribute("clsac");
//cst=(Account) request.getAttribute("class");
Account acc= null; 
String bal=(String) request.getAttribute("beBal");

acc=(Account) request.getAttribute("setdep"); 
if(cst != null) {
%>

<form action="BankController?action=depBalance" method="post">
<input type="hidden" name="vbn" value="<%= cst.getAccountID() %>">
<tr><td>Customer ID</td><td> <label><%=cst.getCustomerID()%></label></td></tr>
<tr><td>Account ID </td><td><label><%=cst.getAccountID() %></label></td></tr>
<tr><td>Account Type </td><td> <label><%=cst.getAccount_type() %></label></td></tr>
<tr><td>Balance </td><td> <label><%=cst.getAmount() %></label></td></tr>
<tr><td>Deposit Balance </td><td> <input type="number" name="DeBal"></td></tr>
<tr><td colspan="2"><input type="submit" value="Submit" style="margin-left:30% ;background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"></td></tr>
</form>
</table>
<% } %>

<% 
if(acc != null) {
%>
<br>
<br>
<table>
<tr><th colspan="2">
<h4>Transaction Details</h4></th></tr>
<tr><td>Customer ID</td><td> <label><%=acc.getCustomerID() %></label></td></tr>
<tr><td>Account ID </td><td> <label><%=acc.getAccountID() %></label></td></tr>
<tr><td>Balance before deposit </td><td><label><%=bal %></label></td></tr>
<tr><td>Latest balance </td><td> <label><%=acc.getAmount() %></label></td></tr>
</table>
<br>
<br>
<h3>Amount deposited successfully</h3>
<% } %>

<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>