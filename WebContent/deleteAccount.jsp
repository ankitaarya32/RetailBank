<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>

<%  String pageTitle="Delete Account";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style type="text/css">
.bg-image {
  /* The image used */
  background-image: url("image/ankit7.jpg");

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
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0, 0.4); 
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
<h2>Delete Account</h2>
<form action="BankController?action=searchAcc" method="post">
<input type="hidden" name="searchvbn" value="delete">
Account ID: <input type="number" name="Acid">
<input type="submit" value="fetch" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>

<% Account cst= null; cst=(Account) request.getAttribute("class"); 
if(cst != null) {
%>
<br>

<form action="BankController?action=deleteAcc" method="post">
<input type="hidden" name="vbn" value="<%= cst.getAccountID() %>">
<h3>Account Detail</h3>
Account ID: <label><%=cst.getAccountID() %></label><br>
Customer ID: <label><%=cst.getCustomerID()%></label><br>
Account Type: <label><%=cst.getAccount_type() %></label><br><br>
<input type="submit" value="delete" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>
<% } %>
<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<br>
<br>
<h3><%=smsg %></h3>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>