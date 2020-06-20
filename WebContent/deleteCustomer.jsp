<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.FFFANS.bean.BankCustomer,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Delete Customer";%>
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

<h2>Delete Customer</h2>
<form action="BankController?action=searchCust" method="post">
Customer ID: <input type="number" name="CID">
<input type="submit" value="fetch" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>

<% BankCustomer cst= null; cst=(BankCustomer) request.getAttribute("class"); 
if(cst != null) {
%>
<br>
<h3>Delete Customer</h3>
<form action="BankController?action=deleteCust" method="post">
<input type="hidden" name="vbn" value="<%= cst.getCustomerId() %>">
Customer ID: <label><%=cst.getCustomerId() %></label><br>
Customer Adhar: <label><%= cst.getCustomerAdhar() %></label><br>
Customer Name: <label><%=cst.getCustomer_name() %></label><br>
Address: <label><%=cst.getAddress() %></label><br>
Age: <label><%=cst.getAge() %></label><br>
<input type="submit" value="delete" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>
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