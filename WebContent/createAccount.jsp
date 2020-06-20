<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Create Account";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style>
.bg-image {
  /* The image used */
  background-image: url("image/ankit3.jpg");

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
<h2>Create Account</h2>
<form action="BankController?action=createAcc" method="post">
Customer ID: <input type="text" name="CID" required><br>
<br>
 Select Account Type:<select name="AccType" required>
<option value="">-- select --</option>
<option >Saving Account</option>
<option >Current Account</option>
</select><br><br>
Deposit Amount: <input type="number" name="amount" required ><br><br>
<input type="submit"  value="Submit" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"><br>
</form>

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