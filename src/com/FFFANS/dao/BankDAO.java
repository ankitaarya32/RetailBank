package com.FFFANS.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.BankCustomer;
import com.FFFANS.bean.Transaction;
import com.FFFANS.util.DatabaseUtil;

public class BankDAO {
	PreparedStatement ps=null;
	
	public void createTable() throws ClassNotFoundException {
		Connection con=DatabaseUtil.getconnection();
		Statement st;
        try {
        	
        	String main="CREATE TABLE `userstore` (\r\n" + 
        			"  `username` varchar(100) DEFAULT NULL,\r\n" + 
        			"  `password` varchar(100) DEFAULT NULL,\r\n" + 
        			"  `last_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP\r\n" + 
        			");";
        	String tab="CREATE TABLE `customer` (\r\n" + 
        			"  `Customer_adhar` int NOT NULL,\r\n" + 
        			"  `Customer_name` varchar(100) DEFAULT NULL,\r\n" + 
        			"  `Age` int DEFAULT NULL,\r\n" + 
        			"  `Address` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `City` varchar(100) DEFAULT NULL,\r\n" + 
        			"  `State` varchar(150) DEFAULT NULL,\r\n" + 
        			"  `Customer_ID` int DEFAULT NULL,\r\n" + 
        			"  `Account_ID` int DEFAULT NULL,\r\n" + 
        			"  `Account_type` varchar(100) DEFAULT NULL,\r\n" + 
        			"  `status` varchar(120) DEFAULT NULL,\r\n" + 
        			"  `message` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `last_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\r\n" + 
        			"  `last_time` time DEFAULT NULL\r\n" + 
        			"  PRIMARY KEY (`Customer_adhar`)\r\n" + 
        			");";
        	String tab1="CREATE TABLE `account` (\r\n" + 
        			"  `Customer_ID` int DEFAULT NULL,\r\n" + 
        			"  `Customer_adhar` int DEFAULT NULL,\r\n" + 
        			"  `Account_ID` int NOT NULL,\r\n" + 
        			"  `Account_type` varchar(250) DEFAULT NULL,\r\n" + 
        			"  `Amount` int DEFAULT NULL,\r\n" + 
        			"  `status` varchar(250) DEFAULT NULL,\r\n" + 
        			"  `message` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `Last_updated` date DEFAULT NULL,\r\n" + 
        			"  `Last_time` time DEFAULT NULL\r\n" + 
        			"  PRIMARY KEY (`Account_ID`),foreign key (`Customer_ID`) references `customer` (`Customer_ID`) \r\n" + 
        			");";
        	String tab2="CREATE TABLE `transaction` (\r\n" + 
        			"  `TransactionId` int DEFAULT NULL,\r\n" + 
        			"  `CustomerId` int DEFAULT NULL,\r\n" + 
        			"  `SoureAccountId` int DEFAULT NULL,\r\n" + 
        			"  `SourceAccountType` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `TargetAccountId` int DEFAULT NULL,\r\n" + 
        			"  `TargetAccountType` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `TransDesc` varchar(500) DEFAULT NULL,\r\n" + 
        			"  `amount` int DEFAULT NULL,\r\n" + 
        			"  `Last_updated` date DEFAULT NULL,\r\n" + 
        			"  `Last_time` time DEFAULT NULL\r\n" + 
        			"  PRIMARY KEY (`TransactionId`),foreign key (`SoureAccountId`) references `account` (`Account_ID`)\r\n" + 
        			");";
            st = con.createStatement(); 
            
            st.execute(tab);
            st.execute(tab1);
            st.execute(tab2);
            System.out.println("Table created !"); 
        } 
        
        
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
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
	int cid=0;
	int aid=0;
	while(result.next()) {
		cid=result.getInt("Cid");
		aid=result.getInt("Aid");
		//cst.setAccountId(result.getInt("Aid")+1);
	}
	if(cid==0)cst.setCustomerId(606200);
	else cst.setCustomerId(cid+1);
	System.out.println("AID is:"+ aid);
	if(aid==0) cst.setAccountId(1062000);   
	else  cst.setAccountId(aid+1);
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
				,result.getDate("last_updated"),result.getTime("last_time"));
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
				,result.getDate("last_updated"),result.getTime("last_time"));
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
				,result.getDate("last_updated"),result.getTime("last_time"));
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
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"),result.getTime("last_time"));
	}
	con.close();
	System.out.println(cst);
	return cst;
	
}

public boolean verifyAccountByAccID(int Aid) throws SQLException {
	ResultSet result=null;
	boolean flag=false;
	Connection con=DatabaseUtil.getconnection();
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select Account_ID from account where Account_ID="+Aid);
	while(result.next()) {
	 if(result.getInt("Account_ID")>0)flag=true;
	}
	con.close();
	return flag;
	
}

public Account depositBalance(int Aid,int upbal) throws SQLException {
	int balance=0;
	Connection con=DatabaseUtil.getconnection();
	ResultSet result=null;
	Account cst=null;
	Transaction tsa=null;
	Statement stmt=con.createStatement();
	result=stmt.executeQuery("select * from account where Account_ID="+Aid);
	while(result.next()) {
		//int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
		//int amount, Date last_updated
		cst=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"),result.getTime("last_time"));
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
	Transaction tsa=null;
	//result=stmt.executeQuery("select * from account where Account_ID="+Aid);
	result=con.createStatement().executeQuery("select * from account where Account_ID="+Aid);
	while(result.next()) {
		//int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
		//int amount, Date last_updated
		cst=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
			result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"),result.getTime("last_time"));
	}
	balance=cst.getAmount()-upbal;
	if(balance>=0) {
		ps=con.prepareStatement("update account set Amount=?,Last_updated=? where Account_ID="+cst.getAccountID());
		ps.setInt(1, balance);
		ps.setDate(2, cst.getLast_updated());
		ps.executeUpdate();
		
		/*ps=con.prepareStatement("insert into transaction(TransactionId,CustomerId ,SoureAccountId ,SourceAccountType ,TargetAccountId ,TargetAccountType ,TransDesc,amount,Last_updated ,Last_time) value(?,?,?,?,?,?,?,?,?,?)");
		result=con.createStatement().executeQuery("select Max(TransactionId) as tid from transaction;");
		int tid=0;
		while(result.next()) {
			tid=result.getInt("tid");
		}
		System.out.println("TID is:"+ tid);
		if(tid==0)tsa.setTransactionId(001000);
		else tsa.setTransactionId(tid+1);
		ps.setInt(1, 00100);
		ps.setInt(2, cst.getCustomerID());
		ps.setInt(3, cst.getAccountID());
		ps.setString(4, cst.getAccount_type());
		ps.setInt(5, cst.getAccountID());
		ps.setString(6, cst.getAccount_type());
		ps.setString(7, "Withdraw");
		ps.setInt(8,upbal);
		ps.setDate(9, tsa.getLast_updated());
		ps.setTime(10, tsa.getLast_time());
		ps.executeUpdate();*/
	}
	else {
		cst.setAmount(0);
	}
	cst.setAmount(balance);
	con.close();
	return cst;
}


public List<Transaction> showbwtransactionBydates(String date,String date1,int accid) throws SQLException{
	List<Transaction> l1=new ArrayList<Transaction>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	String query="select * from  transaction where Last_updated between '"+date+"' and '"+date1+"' and SoureAccountId="+accid;
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	//ps=con.prepareStatement("select * from transaction where Last_updated=?");
	result=con.createStatement().executeQuery(query);
	//result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from transaction where Last_updated="+date);
	
	while(result.next()) {
		//int customerId, int soureAccountId, String sourceAccountType, int targetAccountId,
		//String targetAccountType, String transDesc, int transactionId, int amount, Date last_updated,Time last_time
		Transaction acc=new Transaction(result.getInt("CustomerId"),result.getInt("SoureAccountId"),result.getString("SourceAccountType"),result.getInt("TargetAccountId"),
				result.getString("TargetAccountType"),result.getString("TransDesc"),result.getInt("TransactionId"),result.getInt("amount"),result.getDate("Last_updated"),result.getTime("Last_time"));
		//Transaction acc=new Transaction();
		//acc.setCustomerId(result.getInt("customerId"));
		l1.add(acc);
	System.out.println(acc);
	}
	
	con.close();
	return l1;
}

public List<Account> showAllAccounts() throws SQLException{
	List<Account> l1=new ArrayList<Account>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	String query="select * from  account";
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	//ps=con.prepareStatement("select * from transaction where Last_updated=?");
	result=con.createStatement().executeQuery(query);
	//result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from transaction where Last_updated="+date);
	
	while(result.next()) {
		Account acc=new Account(result.getInt("Customer_ID"),result.getInt("Customer_adhar"),result.getInt("Account_ID"),result.getString("Account_type"),
				result.getString("status"),result.getString("message"),result.getInt("Amount"),result.getDate("Last_updated"),result.getTime("last_time"));
		//Transaction acc=new Transaction();
		//acc.setCustomerId(result.getInt("customerId"));
		l1.add(acc);
	System.out.println(acc);
	}
	
	con.close();
	return l1;
}

public List<Integer> showAccountsByCustomerId(int cid) throws SQLException{
	List<Integer> l1=new ArrayList<Integer>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	String query="select Account_ID from  account where Customer_ID="+cid;
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	//ps=con.prepareStatement("select * from transaction where Last_updated=?");
	result=con.createStatement().executeQuery(query);
	//result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from transaction where Last_updated="+date);
	
	while(result.next()) {
		l1.add(result.getInt("Account_ID"));
	}
	
	con.close();
	return l1;
}

public List<Integer> showAccountsByAdharId(int cid) throws SQLException{
	List<Integer> l1=new ArrayList<Integer>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	String query="select Account_ID from  account where Customer_adhar="+cid;
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	//ps=con.prepareStatement("select * from transaction where Last_updated=?");
	result=con.createStatement().executeQuery(query);
	//result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from transaction where Last_updated="+date);
	
	while(result.next()) {
		l1.add(result.getInt("Account_ID"));
	}
	
	con.close();
	return l1;
}

public List<Transaction> showbwtransactionBycount(int accid,int num) throws SQLException{
	List<Transaction> l1=new ArrayList<Transaction>();
	ResultSet result=null;
	Connection con=DatabaseUtil.getconnection();
	String query="select * from transaction where SoureAccountId="+accid+" order by TransactionId desc LIMIT "+num;
	//String query="select * from  transaction ORDER BY TransactionId DESC LIMIT "+num+" where Last_updated between '"+date+"' and '"+date1+"' and SoureAccountId="+accid;
	//result=con.createStatement().executeQuery("select * from account where Account_ID=?");
	//ps=con.prepareStatement("select * from transaction where Last_updated=?");
	result=con.createStatement().executeQuery(query);
	//result=ps.executeQuery();
	
	//result=stmt.executeQuery("select * from transaction where Last_updated="+date);
	
	while(result.next()) {
		//int customerId, int soureAccountId, String sourceAccountType, int targetAccountId,
		//String targetAccountType, String transDesc, int transactionId, int amount, Date last_updated,Time last_time
		Transaction acc=new Transaction(result.getInt("CustomerId"),result.getInt("SoureAccountId"),result.getString("SourceAccountType"),result.getInt("TargetAccountId"),
				result.getString("TargetAccountType"),result.getString("TransDesc"),result.getInt("TransactionId"),result.getInt("amount"),result.getDate("Last_updated"),result.getTime("Last_time"));
		//Transaction acc=new Transaction();
		//acc.setCustomerId(result.getInt("customerId"));
		l1.add(acc);
	System.out.println(acc);
	}
	
	con.close();
	return l1;
}

public Account transfermoney() {
	Account cst=null;
	return cst;
}
public boolean insertintotransaction(Transaction tsa,Account cst, int upbal) throws SQLException {
	boolean flag=false;
	Connection con=DatabaseUtil.getconnection();
	ResultSet result=null;
	ps=con.prepareStatement("insert into transaction(CustomerId ,SoureAccountId ,SourceAccountType ,TransactionId,TargetAccountId ,TargetAccountType ,TransDesc,amount,Last_updated ,Last_time) value(?,?,?,?,?,?,?,?,?,?)");
	
	ps.setInt(1, cst.getCustomerID());
	ps.setInt(2, cst.getAccountID());
	ps.setString(3, cst.getAccount_type());
	result=con.createStatement().executeQuery("select Max(TransactionId) as tid from transaction;");
	int Tid=0;
	while(result.next()) {
		Tid=result.getInt("tid");
	}
	if(Tid==0) {tsa.setTransactionId(01000);System.out.println("running if");}
	else {tsa.setTransactionId(Tid+1); System.out.println("running else");}

	ps.setInt(4,tsa.getTransactionId());
	ps.setInt(5, cst.getAccountID());
	ps.setString(6, cst.getAccount_type());
	ps.setString(7, tsa.getTransDesc());
	ps.setInt(8,upbal);
	ps.setDate(9, tsa.getLast_updated());
	ps.setTime(10, tsa.getLast_time());
	int rowstatus=ps.executeUpdate();
	DatabaseUtil.closeStatement(ps);
	if(rowstatus>0) {
		System.out.println("Executed successful");
	flag= true;}
	con.close();
	return flag;
}
}

