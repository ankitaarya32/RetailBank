<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.FFFANS.bean.Transaction,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>th{font-size:22px; background-color:yellow;color:black;}
td{font-size:22px;background-color:white; color:black;}</style>
<%  String pageTitle="Show Transaction";%>
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

<h1>Account Statement</h1>
<form action="BankController?action=transdetail" method="post">
Account ID: <input type="number" name="ais" required><br><br>
<input type="radio" name="trans" value="nTransac" required> Last Number of Transaction<br>
<input type="number" name="numtrans">
<h4>--or--</h4>
<input type="radio" name="trans" value="rangeTrans"> Start End Date<br>
Start Date(YYYY/MM/DD) <input type="text" name="sdate" pattern="\d{4}/\d{1,2}/\d{1,2}"><br><br>

End Date(YYYY/MM/DD) <input type="text" name="edate" pattern="\d{4}/\d{1,2}/\d{1,2}"><br>
<input type="submit" value="submit"> <br>
</form>
<% List<Transaction> cust=null;
cust=(List<Transaction>) request.getAttribute("listcust"); 
if(cust!=null){ %>
<br>
<table border="1">
<tr>
<th>Transaction ID</th>
<th>Description</th>
<th>Date</th>
<th>Amount</th>
</tr>
<% 
for(Transaction x:cust) {
%>

<tr>
<td><%=x.getTransactionId() %></td>
<td><%=x.getTransDesc() %></td>
<td><%=x.getLast_updated() %></td>
<td><%=x.getAmount() %></td>
</tr>
<% } }%>
</table>
<br>
<%  String ids=(String)request.getAttribute("msgs"); %>
  <% if(ids!=null){ %>
<h3 id="msg"><%=ids %></h3>
<% } %> 
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>