package com.FFFANS.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.BankCustomer;
import com.FFFANS.util.DatabaseUtil;

public class BankDAO {
	PreparedStatement ps=null;
	
public boolean addCustomer(BankCustomer cst) throws SQLException,ClassNotFoundException{
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	boolean flag=false;
	ps=con.prepareStatement("insert into Customer(customer_adhar,customer_name,age,address,city,state,customer_id,account_id,account_type,status,message) value(?,?,?,?,?,?,?,?,?,?,?);");
	ps.setInt(1, cst.getCustomerAdhar());
	ps.setString(2, cst.getCustomer_name());
	ps.setInt(3, cst.getAge());
	ps.setString(4, cst.getAddress());
	ps.setString(5, cst.getCity());
	ps.setString(6, cst.getState());
	result=con.createStatement().executeQuery("select Max(customer_Id) as Cid ,Max(account_id)as Aid from Customer;");
	while(result.next()) {
		cst.setCustomerId(result.getInt("Cid")+1);
		cst.setAccountId(result.getInt("Aid")+1);
	}
	
	ps.setInt(7, cst.getCustomerId());
	ps.setInt(8, cst.getAccountId());
	ps.setString(9, cst.getAccount_type());
	ps.setString(10, "Active");
	String msg="This user has "+ cst.getAccount_type();
	ps.setString(11, msg);	
	int rowstatus=ps.executeUpdate();
	DatabaseUtil.closeConnection(con);
	DatabaseUtil.closeStatement(ps);
	if(rowstatus>0) {
	flag=true;}
	return flag;
}
public int sendCustomerId(BankCustomer cst) throws SQLException {
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	int acc=0;
	result=stmt.executeQuery("select customer_id from customer where customer_adhar="+cst.getCustomerAdhar());
	while(result.next()) {
		acc=result.getInt("customer_id");
		System.out.println(acc);
	}
	con.close();
	return acc;
}

public boolean verifyCustomer(String user,String pass) throws SQLException,ClassNotFoundException{
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	boolean flag=false;
	System.out.println("verifying details : "+flag);
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select customer_id,customer_adhar from Customer where customer_id="+Integer.parseInt(user)+" and customer_adhar="+Integer.parseInt(pass));
	if(result!=null) {
		ps=con.prepareStatement("insert into userstore(username,password) value(?,?);");
	while(result.next()) {	
		ps.setInt(1, result.getInt("customer_id"));
		ps.setInt(2, result.getInt("customer_adhar"));
		ps.executeUpdate();
		flag=true;
		System.out.println("verified details :" +flag);
	}
	
	}
	System.out.println("not verified:"+ flag);
	con.close();
	return flag;
}

public BankCustomer searchCustomerByAdhar(int cadhar) throws SQLException {
	ResultSet result=null;
	BankCustomer cst=null;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from customer where customer_adhar="+cadhar);
	while(result.next()) {
		cst=new BankCustomer(result.getInt("customer_id"),result.getInt("customer_adhar"),result.getString("customer_name"),
				result.getInt("age"),result.getString("address"),result.getString("city"),result.getString("state"),result.getInt("account_id"),
				result.getString("account_type"),result.getString("status"),result.getString("message")
				,result.getDate("last_updated"));
	}
	System.out.println(cst);
	con.close();
	return cst;
	
}

public BankCustomer searchCustomerByCusID(int cid) throws SQLException {
	ResultSet result=null;
	BankCustomer cst=null;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from customer where customer_id="+cid);
	while(result.next()) {
		cst=new BankCustomer(result.getInt("customer_id"),result.getInt("customer_adhar"),result.getString("customer_name"),
				result.getInt("age"),result.getString("address"),result.getString("city"),result.getString("state"),result.getInt("account_id"),
				result.getString("account_type"),result.getString("status"),result.getString("message")
				,result.getDate("last_updated"));
	}
	con.close();
	System.out.println(cst);
	return cst;
	
}


public boolean verifyexecUser(String user,String pass) throws SQLException,ClassNotFoundException{
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	boolean flag=false;
	System.out.println("verifying details : "+flag);
	ps=con.prepareStatement("select * from execstore where username=? and password=? ;");
	ps.setString(1, user);
	ps.setString(2, pass);
	result=ps.executeQuery();
	while(result.next()) {		
		flag=true;
	}
	
	con.close();
	return flag;
}

public boolean updateUser(BankCustomer cst) throws SQLException {
	boolean flag=false;
	Connection con=DatabaseUtil.getconnection();
	System.out.println(cst.getCustomerId());
	System.out.println(cst.getCustomer_name());
	ps=con.prepareStatement("update customer set customer_name=?,age=?,address=? where customer_id="+cst.getCustomerId());
	ps.setString(1, cst.getCustomer_name());
	ps.setInt(2, cst.getAge());
	ps.setString(3, cst.getAddress());
	int rowstatus=ps.executeUpdate();
	DatabaseUtil.closeConnection(con);
	DatabaseUtil.closeStatement(ps);
	if(rowstatus>0) {
		System.out.println("Executed successful");
	flag= true;}
	return flag;
	
}

public List<BankCustomer> showCustomers() throws SQLException{
	List<BankCustomer> l1=new ArrayList<BankCustomer>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from customer;");
	while(result.next()) {
		 BankCustomer cst=new BankCustomer(result.getInt("customer_id"),result.getInt("customer_adhar"),result.getString("customer_name"),
				result.getInt("age"),result.getString("address"),result.getString("city"),result.getString("state"),result.getInt("account_id"),
				result.getString("account_type"),result.getString("status"),result.getString("message")
				,result.getDate("last_updated"));
	l1.add(cst);
	}
	
	con.close();
	return l1;
}
public int getadhar(int cid) throws SQLException {
	ResultSet result=null;
	int adhar=0;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	System.out.println("creating statement");
	result=stmt.executeQuery("select customer_adhar from customer where customer_id="+cid);	
	System.out.println("closing statement");
	while(result.next()) {
		adhar=result.getInt("customer_adhar");
	}
	System.out.println(adhar);
	con.close();
	return adhar;
}

public boolean createAccount(Account acc) throws SQLException {
	boolean flag=false;
	ResultSet result=null;
	System.out.println("account creation initiated");
	Connection con=DatabaseUtil.getconnection();
	
		flag=true;
		System.out.println("successfully got adhar"+ acc.getCustomerAdhar());
		ps=con.prepareStatement("insert into account(Customer_ID, customer_adhar, Account_ID, Account_type,Amount, status, message, Last_updated) value (?,?,?,?,?,?,?,?) ;");
		ps.setInt(1, acc.getCustomerID());
		ps.setInt(2, acc.getCustomerAdhar());
		result=con.createStatement().executeQuery("select Max(Account_ID) as aid from account;");
		int aid=0;
		while(result.next()) {
			aid=result.getInt("aid");
		}
		System.out.println("AID is:"+ aid);
		if(aid==0)acc.setAccountID(1062000);
		else acc.setAccountID(aid+1);
		ps.setInt(3, acc.getAccountID());
		ps.setString(4, acc.getAccount_type());
		ps.setInt(5, acc.getAmount());
		ps.setString(6, acc.getStatus());
		ps.setString(7, acc.getMessage());
		ps.setDate(8, acc.getLast_updated());
		flag=false;
		int rowstatus=ps.executeUpdate();
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		if(rowstatus>0) {
			System.out.println("Executed successful");
		flag= true;}
		
	
	con.close();
	return flag;
}

public boolean deleteCustomer(int cid) throws SQLException {
	boolean flag=false;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	int rowstatus=stmt.executeUpdate("delete from customer where customer_id="+cid);
	if(rowstatus>0) {
		System.out.println("Executed successful");
	flag= true;}
	return flag;
}

public boolean deleteAccount(int Aid) throws SQLException {
	boolean flag=false;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	int rowstatus=stmt.executeUpdate("delete from account where Account_ID="+Aid);
	if(rowstatus>0) {
		System.out.println("Executed successful");
	flag= true;}
	return flag;
}

public Account searchAccountByAccID(int Aid) throws SQLException {
	ResultSet result=null;
	Account cst=null;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from account where Account_ID="+Aid);
	while(result.next()) {
		//int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
		//int amount, Date last_updated
		cst=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"));
	}
	con.close();
	System.out.println(cst);
	return cst;
	
}

public Account depositBalance(int Aid,int upbal) throws SQLException {
	int balance=0;
	Connection con=DatabaseUtil.getconnection();
	ResultSet result=null;
	Account cst=null;
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from account where Account_ID="+Aid);
	while(result.next()) {
		//int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
		//int amount, Date last_updated
		cst=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"));
	}
	balance=upbal+cst.getAmount();
	ps=con.prepareStatement("update account set Amount=?,Last_updated=? where Account_ID="+cst.getAccountID());
	ps.setInt(1, balance);
	ps.setDate(2, cst.getLast_updated());
	ps.executeUpdate();
	cst.setAmount(balance);
	return cst;
}

public Account withdrawBalance(int Aid,int upbal) throws SQLException {
	int balance=0;
	Connection con=DatabaseUtil.getconnection();
	ResultSet result=null;
	Account cst=null;
	//result=stmt.executeQuery("select * from account where Account_ID="+Aid);
	result=con.createStatement().executeQuery("select * from account where Account_ID="+Aid);
	while(result.next()) {
		//int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
		//int amount, Date last_updated
		cst=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"));
	}
	balance=cst.getAmount()-upbal;
	if(balance>=0) {
		ps=con.prepareStatement("update account set Amount=?,Last_updated=? where Account_ID="+cst.getAccountID());
		ps.setInt(1, balance);
		ps.setDate(2, cst.getLast_updated());
		ps.executeUpdate();
	}
	else {
		cst.setAmount(0);
	}
	cst.setAmount(balance);
	con.close();
	return cst;
}


public List<Account> showbwtransactionBydates(Date date) throws SQLException{
	List<Account> l1=new ArrayList<Account>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	ps=con.prepareStatement("select * from account where Last_updated=?");
	ps.setDate(1, (java.sql.Date)date);
	result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from account where Last_updated="+date);
	
	while(result.next()) {
		Account acc=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
				result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"));
	l1.add(acc);
	System.out.println(acc);
	}
	
	con.close();
	return l1;
}
}
