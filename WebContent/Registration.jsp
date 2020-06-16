<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style type="text/css">
#msg{background-color: yellow; color: green}
</style>
</head>
<body>
<form action="BankController" method="post">
Account Type: <input type="radio" value="current" name="acctype"> Current Account
<input type="radio" value="saving" name="acctype"> Saving Account<br>
Adhar Card: <input type="number" name="adhar" maxlength="12"><br>
Customer Name: <input type="text" name="Cname"><br>
Age: <input type="number" name="age"><br>
Address: <input type="text" name="address"><br>
State: <select name="state">
<option>select</option>
<option>Mumbai</option>
<option>Bihar</option>
</select><br>
City: <select name="city">
<option>select</option>
<option>BiharSharif</option>
<option>Nalanda</option>
</select><br>
<input type="submit" name="action" value="Register"> 
</form>
<%  String ids=(String)request.getAttribute("succ_msg"); %>
  <% if(ids!=null){ %>
<h3 id="msg"><%=ids%></h3>
<% } %> 
</body>
</html>