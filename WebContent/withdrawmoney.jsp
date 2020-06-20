<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#button{
padding:5px;
background-color:blue;
font-color:orange;
font-size:20px;
border-radius:10px;
cursor:pointer;
font-weight:bold;
transition:background-color 2s ease 0s;
margin-left:30%;
}
#button:hover{
background-color:orange;
font-color:black;
}
</style>
<%  String pageTitle="Withdraw Money";%>
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
  background-image: url("image/ankit4.jpg");

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

<!--  <form action="BankController?action=searchAcc" method="post">
<input type="hidden" name="searchvbn" value="withdraw">
Account ID: <input type="number" name="Acid">
<input type="submit" value="fetch">
</form>
-->

<% Account cst= null; 
cst=(Account) session.getAttribute("clsac");
//cst=(Account) request.getAttribute("class");
Account acc= null; 
String bal=(String) request.getAttribute("witBal");

acc=(Account) request.getAttribute("setdep"); 
if(cst != null) {
%>
<table>
<tr>
<th colspan="2">
<h1>Withdraw Money</h1> </th></tr>
<form action="BankController?action=witBalance" method="post">
<input type="hidden" name="vbn" value="<%= cst.getAccountID() %>">
<tr><td>Customer ID </td><td> <label><%=cst.getCustomerID()%></label></td></tr>
<tr><td>Account ID</td><td> <label><%=cst.getAccountID() %></label></td></tr>
<tr><td>Account Type</td><td> <label><%=cst.getAccount_type() %></label></td></tr>
<tr><td>Balance</td><td> <label><%=cst.getAmount() %></label></td></tr>
<tr><td>Withdraw Balance</td><td> <input type="number" name="WeBal"></td></tr>
<tr><td colspan="2"><input type="submit" value="Submit" style="margin-left:30% ;background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"></td></tr>
</form>
</table>
<% } %>

<% 
if(acc != null) {
%>
<br>
<br>
<h4>Transaction details</h4>
Customer ID: <label><%=acc.getCustomerID() %></label><br>
Account ID : <label><%=acc.getAccountID() %></label><br>
Balance before deposit :<label><%=bal %></label><br>
Latest balance : <label><%=acc.getAmount() %></label><br>
<h3>Amount deposited successfully</h3><br>
<% } %>

<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3><br>
<% } %>

<% String smsg2=(String)request.getAttribute("rsms"); if(smsg2 != null) { %>
<h3><%=smsg2 %></h3>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>