<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%  String pageTitle="Home";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style>
  #id{
    font-size: 50px
    font-s
  }
  body,html {
  height: 100%;
  margin: 0;
  font-family: garamond, Helvetica, sans-serif;  
}
* {
  box-sizing: border-box;
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
<body style="background-image: url('image/ankit2.jpg');">
  <div class="bg-text">
<center>
<div>
<%  String ids=(String)session.getAttribute("name");
if(ids!=null){%>
<h2 id="msg">Welcome <%=ids%></h2>
<% } %>
</div>
<% if(ids==null) {   %>
<center>
<h4>Session expired.........</h4>
<a href="BankController?action=Logout">Login again</a>
</center>
<% } %>
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>