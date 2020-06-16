<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankController?action=createAcc" method="post">
Customer ID: <input type="text" name="CID">
<select name="AccType">
<option >Saving Account</option>
<option >Current Account</option>
</select>
Deposit Amount: <input type="number" name="amount" >
<input type="submit"  value="Submit">
</form>

<% String smsg=(String)request.getAttribute("sumsg"); if(smsg != null) { %>
<h3><%=smsg %></h3>
<% } %>
</body>
</html>