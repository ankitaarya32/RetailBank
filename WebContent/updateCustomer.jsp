<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.FFFANS.bean.BankCustomer,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Update Customer";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>


<style type="text/css">
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

<h3>Update Customer</h3>
<form action="BankController" method="post">
<input type="radio" name="search" value="cadhar" id="chkYes">Enter Customer Adhar:
<input type="text" name="adhar"  id="csadhar"><br>
<h4> --or--</h4>

<input type="radio" name="search" value="cid" id="chkNo">Enter Customer ID:
<input type="text" name="CusID"  id="asaid"><br><br>
<input type="submit" name="action" value="EditCustomer" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
<br>
</form>

<% BankCustomer cst= null; cst=(BankCustomer) request.getAttribute("class"); 
if(cst != null) {
%>
<table>
<tr><th colspan="2">
<h4>Customer Detail</h4></th></tr>
<form action="BankController" method="post">
<input type="hidden" name="vbn" value="<%= cst.getCustomerId() %>">
<tr><td>Customer Adhar</td><td> <label><%= cst.getCustomerAdhar() %></label></td></tr>
<tr><td>Customer ID</td><td> <label><%=cst.getCustomerId() %></label></td></tr>
<tr><td>Old Customer Name</td><td> <label><%=cst.getCustomer_name() %></label></td></tr>
<tr><td>New Customer Name</td><td> <input type="text" name="Cname" value="<%=cst.getCustomer_name() %>"></td></tr>
<tr><td>Old Address</td><td><label><%=cst.getAddress() %></label></td></tr>
<tr><td>New Address</td><td> <input type="text" name="Caddress" value="<%=cst.getAddress() %>"></td></tr>
<tr><td>Old Age</td><td> <label><%=cst.getAge() %></label></td></tr>
<tr><td>New Age</td><td> <input type="text" name="Cage" value="<%=cst.getAge() %>"></td></tr>
<tr><td colspan="2"><input type="submit" name="action" value="UpdateCustomer" style="margin-left:30% ;background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"></td></tr>
</form>
</table>
<% } %>

<% String smsg=(String)request.getAttribute("upmsg");
System.out.println("Successfull updated"+smsg);
if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>