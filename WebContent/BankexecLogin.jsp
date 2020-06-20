<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,html {
  height: 100%;
  margin: 0;
  font-family: garamond, Helvetica, sans-serif;  
}
* {
  box-sizing: border-box;
}
form {border: 3px solid white; width: 300px; padding: 20px; border-radius: 5px; 
}

input[type=text], input[type=password] {
  width: 250px;
  padding: 8px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 4px;
}

button {
  background-color: black;
  color: white;
  padding: 10px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 250px;
  border-radius: 4px;
}

button:hover {
  opacity: 0.8;
}
.bg-image {
  /* The image used */
  background-image: url("image/ankit.jpg");

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
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="bg-image"></div>
      <div class="bg-text">
<div align="center" >
    <h1 id="msg" style="font-size:70px">Welcome to Motive Bank</h1>
    <form action="BankController" method="post" >
    <h1 align="left">Login</h1>
     <br>               
    <div align="left">
    <i class="fa fa-user-circle-o" style="font-size:15px;color:white"></i>
    <label for="uname"><b>Username</b></label><br>
    </div>
    <input type="text" placeholder="Enter Username" name="username" required pattern=".{8,}" minlength="8" title="usename should be alphanumeric and minumum 8 character">
    <br>
    <div align="left">
    <i class="fa fa-lock" style="font-size:20px;color:white"></i>
    <label for="psw"><b>Password</b></label><br>
    </div>
    <input type="password" placeholder="Enter Password" name="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{10,}" title="password must be minimum 10 character and having one upper,one lower,one special and numeric">
     <br>   
    <button type="submit" name="action" value="execLogin">Login</button>
    <br>
    <br>
    </form>
    </div>
</div>


<!--  
<center>
<table>
<tr>
<th colspan="2">
<h1>Bank Executive Login</h1> <th>
</tr>
<form action="BankController" method="post">
<tr>
<td>Enter username<span style='color:red;'>*</span> </td> <td><input type="text" name="username" placeholder="username" pattern=".{8,}" minlength="8" required title="usename should be alphanumeric and minumum 8 character" ></td></tr>
<tr><td>
Password<span style='color:red;'>*</span> </td><td><input type="password" name="password" placeholder="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{10,}" title="password must be minimum 10 character and having one upper,one lower,one special and numeric" required></td></tr>
<tr><td colspan="2"><input type="submit" name="action" value="execLogin" id="submit"></td></tr>
</form>
</table>   -->
<center>
<%  String ids=(String)request.getAttribute("ermsg"); %>
  <% if(ids!=null){ %>
<h3 id="msg"><%=ids%></h3>
<% } %> 
</center>
</body>
</html>