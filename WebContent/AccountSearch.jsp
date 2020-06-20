<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.FFFANS.bean.Account,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
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
<%  String pageTitle="Search Account";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>

</head>
<body>
<div class="bg-text">
<center>
<h3>Account Search</h3>
<% //String xid=(String)request.getParameter("sout");
List<Integer> l1=null;
l1=(List<Integer>) request.getAttribute("sout");
if(l1 != null){
%>
<form action="BankController?action=searchAcc" method="post">
<input type="hidden" name="searchvbn" value="searchAcc1">
Account ID: <input type="number" name="Acid" value="<%=l1.get(0) %>">
<input type="submit" value="fetch" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>
<%} %>
<% if(l1==null) { %>
<form action="BankController?action=searchAcc" method="post">
<input type="hidden" name="searchvbn" value="searchAcc1">
Account ID: <input type="number" name="Acid" >
<input type="submit" value="fetch" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>
<% } %>
<% Account cst= null; cst=(Account) request.getAttribute("class");
session.setAttribute("clsac", cst);
if(cst != null) {
%>
<br>
<br>
<h4>Account Detail</h4>
Customer ID: <label><%=cst.getCustomerID() %></label><br>
Account ID: <label><%=cst.getAccountID() %></label><br>
Account type: <label><%=cst.getAccount_type() %></label><br>
Balance : <label><%=cst.getAmount() %></label>
<br>
<br>
<div class="optmon">
<tr><td>
<button><a href="depositmoney.jsp" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"> Deposit</a></td></tr></button>
<button><tr><td><a href="withdrawmoney.jsp" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"> Withdraw</a></td></tr></button>
<button><tr><td><a href="transfermoney.jsp" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"> Transfer</a></td></tr></button>
</div>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>