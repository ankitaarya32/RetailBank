<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<title><%=request.getParameter("pagetitle") %></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html{position: relative;
    min-height: 100%;}
body {
    margin: 0;
    width: 100vw;
    height: 100vh;
}

.navbar {
  overflow: hidden;
  background-color: yellow;
  font-famil: garamond , Helvetica, sans-serif;
  align-content: center;
  align-items: center;
  height: auto;
  width: auto;
  align-self: center;
  max-width: inherit;
  margin-left: 15%;
  margin-right: 15%;
  text-align: center;
  
}

.navbar a {
  float: left;
  font-size: 18px;
  color: white;
  text-align: center;
  text-decoration: none;
  margin-left:10px;
 
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  cursor: pointer;
  font-size: 18px;  
  border: none;
  outline: none;
  color: white;
  background-color: inherit;
  font-family: inherit;
  margin-left:10px;
    text-decoration: none;
}

.navbar a:hover, .dropdown:hover .dropbtn, .dropbtn:focus {
  background-color: transparent;
    opacity: 0.5;
    text-align: center;
    text-decoration:none;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: white;
  min-width: 160px;
  box-shadow: 0px 4px 8px 0px rgba(0,0,0,0.2);
  z-index: 1;
    text-decoration: none;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 6px 8px;
  text-decoration: none;
  display: block;
  text-align: left;
    text-decoration: none;
}

.dropdown-content a:hover {
  background-color: #fffcfc;
    text-decoration: none;
  
}

.show {
  display: block;
}
.bank_name
    {
        margin-left:15%;
        font-size: 25px;
        font-family: serif;
        padding-bottom: 0px;
        padding-top:0px;
        background-color: black;
        text-align: match-parent;
        margin-top: 0px;
        margin-bottom: 5px;
         }
    header
    {
        background-color: black;
        
    }
   
   

 .footer {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: black;
  color: white;
  text-align: center;
}
</style>
<script>
    
window.myFunction = function(e) {
  var dropdown = e.parentNode.getElementsByClassName('dropdown-content')[0];
    var dropBtns = document.querySelectorAll('.dropbtn');
    closeOpenItems();
  dropdown.classList.toggle('show');
}
 function closeOpenItems() {
      openMenus = document.querySelectorAll('.dropdown-content');
      openMenus.forEach(function(menus) {
        menus.classList.remove('show');
      });  
  }

window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  closeOpenItems();
  }
}

</script>
</head>
<body>
<div class="container">  
<header>
<p class="bank_name" style="color: yellow" >Motive <span style="color: white">Bank</span></p>    

<div class="navbar" >
  <a href="BankController?action=home" style="color: black" >Home</a>
  
  <div class="dropdown">
  <button class="dropbtn" onclick="myFunction(this)" style="color: black">Customer Management
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="cm_d">
    <a href="BankController?action=regcus">Customer Registration</a>
    <a href="updateCustomer.jsp" name="editCustomer">Update Customer</a>
    <a href="BankController?action=delcus">Delete Customer</a>
    
  </div>
  </div>
    
      <div class="dropdown">
  <button class="dropbtn" onclick="myFunction(this)" style="color: black">Account Management
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="am_d">
    <a href="BankController?action=creaus">Create Account</a>
    <a href="BankController?action=delAcc">Delete Account</a>
    
  </div>
  </div>

      <div class="dropdown">
  <button class="dropbtn" onclick="myFunction(this)" style="color: black">Status Details
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="sd_d">
  <a href="BankController?action=showCustomer">Customer Status</a>
   <a href="BankController?action=showAccount">Account Status</a>
  </div>
  </div>

    
      <div class="dropdown">
  <button class="dropbtn" onclick="myFunction(this)" style="color: black">Account Operations
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="ao_d">
    
    <a href="BankController?action=searCus">Search Customer</a>
    <a href="BankController?action=searAus">Search Account</a>
    <a href="BankController?action=getTrans">Show Transaction</a>
  </div>
  </div>

    
  <a href="BankController?action=Logout" style="color: black">Logout</a>
</div>

</header>
</div> 

