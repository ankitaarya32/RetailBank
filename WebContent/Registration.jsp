<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%  String pageTitle="Registration";%>
<jsp:include page="header.jsp" flush="true">
<jsp:param value="<%=pageTitle %>" name="pagetitle"/>
</jsp:include>
<style type="text/css">
#msg{background-color: yellow; color: green}
#submit{margin-left:30%}
input{border-radius:15px;}
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
<table>
<tr>
<th colspan="2">
<h3>Create Customer</h3></th>
<form action="BankController" method="post">
<!--  Account Type: <input type="radio" value="current" name="acctype"> Current Account
<input type="radio" value="saving" name="acctype"> Saving Account<br>
Adhar Card: <input type="number" name="adhar" maxlength="12"><br>
Customer Name: <input type="text" name="Cname"><br>
Age: <input type="number" name="age"><br>
Address: <input type="text" name="address"><br> -->
<tr><td>Account Type<span style="color:red;">*</span></td><td><input type="radio" value="current" name="acctype" required> Current Account</td>
<td><input type="radio" value="saving" name="acctype"> Saving Account</td></tr>
<tr><td>Aadhar Number<span style="color:red;">*</span></td><td><input type="text" name="adhar" maxlength="9" required></td></tr>
<tr><td>Customer Name<span style="color:red;">*</span></td><td><input type="text" name="Cname" required></td></tr>
<tr><td>Age<span style="color:red;">*</span></td><td><input typae="number" name="age" required></td></tr>
<tr><td>Address<span style="color:red;">*</span></td><td><input type="text" name="address" required></td></tr>
<tr><td>State<span style="color:red;">*</span></td>
<td><select name="state" placeholder="Ënter state" required>
    <option value="" >Select State</option>
    <option>Andhra Pradesh</option>
<option >Andaman and Nicobar Islands</option>
<option >Arunachal Pradesh</option>
<option >Assam</option>
<option >Bihar</option>
<option>Chandigarh</option>
<option >Chattisgarh</option>
<option >Dadar and Nagar Haveli</option>
<option >Daman and Diu</option>
<option >Delhi</option>
<option>Lakshadweep</option>
<option >Puducherry</option>
<option>Goa</option>
<option>Gujarat</option>
<option >Haryana</option>
<option >Himachal Pradesh</option>
<option >Jammu and Kashmir</option>
<option >Jharkhand</option>
<option>Karnataka</option>
<option >Kerala</option>
<option >Madhya Pradesh</option>
<option >Maharashtra</option>
<option >Manipur</option>
<option>Meghalaya</option>
<option >Mizoram</option>
<option >Nagaland</option>
<option >Odisha</option>
<option >Punjab</option>
<option >Rajasthan</option>
<option >Sikkim</option>
<option >Tamil Nadu</option>
<option >Telangana</option>
<option >Tripura</option>
<option >Uttar Pradesh</option>
<option>Uttarakhand</option>
<option>West Bengal</option>
</select></td></tr>
<tr><td>City<span style="color:red;">*</span></td>
<td><select name="city" required>
    <option value="" >Select City</option>
    <option >Alipur</option>
    <option >Ballari</option>
    <option >Adoni</option>
    <option>Sikkim</option>
     <option>Mumbai</option>
     <option>Delhi</option>
     <option>Bangalore</option>
     <option>Hyderabad</option>
     <option>ahmedabad</option>
     <option>Chennai</option>
     <option>Kolkata</option>
     <option>Surat</option>
     <option>Pune</option>
     <option>Jaipur</option>
     <option>Vishakapatnam</option>
     <option>Nagpur</option>
     <option>Kanpur</option>
     <option>Lucknow</option>
     <option>Thane</option>
     <option>Bhopal</option>
     <option>Indore</option>
     <option>Patna</option>
     <option>Vadodara</option>
     <option>Agra</option>
     <option>Ludhiana</option>
     <option>Nasik</option>
     <option>Meerut</option>
     <option>Rajkot</option>
     <option>Varanasi</option>
     <option>Jabalpur</option>
     <option>Coimbatore</option>
     <option>Gwalior</option>
     <option>Jodhpur</option>
     <option>Bhuvaneshvar</option>
     <option>Dehradun</option>
     <option>Gaya</option>
     <option>Thiruvananthapuram</option>
     <option>Eluru</option>
     <option>Kadapa</option>
     <option>Pondicherry</option>
     <option>Nandyal</option>
     <option>Shimla</option>
     <option>Udupi</option>
     <option>Guntakal</option>
     <option>Hospet</option>
     <option>Amaravati</option>
     <option>Gangtok</option>
     <option>Kavali</option>
     <option>Bihar</option>
     <option>Other</option>
</select>
</td></tr>
<tr>
    <td><p style="color:red">(*)Fields are compulsory<br></p></td></tr>
<tr><td colspan="2"><input type="submit" name="action" value="Register" id="submit" style="background-color:black; color:yellow; cell-spacing:50px;cell-padding:10px 0px 10px;"> 
</form>
</tr>
</table>
<%  String ids=(String)request.getAttribute("succ_msg"); %>
  <% if(ids!=null){ %>
<h3 id="msg"><%=ids%></h3>
<% } %> 
</center>
</div>
<div class="footer">
<footer id="footer">
<jsp:include page="footer.jsp"></jsp:include>
</footer>
</div>