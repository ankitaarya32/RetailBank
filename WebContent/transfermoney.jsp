<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.FFFANS.bean.Transaction,java.util.*,com.FFFANS.bean.Account"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Transfer Money";%>
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
  background-image: url("image/ankit6.jpg");

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
<h1>Transfer Money</h1>
<form action="BankController?action=transfer" method="post">
Source Account : <input type="number" name="Sacc"><br>
Target Account: <input type="number" name="Tacc"><br>
Transfer Amount: <input type="number" name="Tamo"><br><br>
<input type="submit" value="Submit" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;">
</form>

<% Transaction tsa=(Transaction)request.getAttribute("acc2");
Account acc=(Account)request.getAttribute("acc");
Account acc1=(Account)request.getAttribute("acc1");
if(tsa != null) { %>
<br>
<br>
<h3>Transfer Receipt</h3>
Source Account ID: <label><%=tsa.getSoureAccountId() %></label><br>
Target Account ID:<label><%=tsa.getTargetAccountId() %></label><br>
Latest balance in Source Account: <label><%=acc.getAmount() %></label> <br>
Latest balance in Target Account: <label><%=acc1.getAmount() %></label> <br>

<% } %>

<% String smsg=(String)request.getAttribute("transBal"); if(smsg != null) { %>
<h3><%=smsg %></h3>
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