package com.FFFANS.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.BankCustomer;
import com.FFFANS.bean.Transaction;
import com.FFFANS.dao.BankDAO;

public class BankService {
	BankDAO cDao=new BankDAO();
	public boolean addCustomer(BankCustomer customer) throws SQLException,ClassNotFoundException{
		return cDao.addCustomer(customer);
	}

public int sendCustomerId(BankCustomer cst) throws SQLException{
	return cDao.sendCustomerId(cst);
}

public boolean verifyCustomer(String user,String pass) throws SQLException,ClassNotFoundException{
	return cDao.verifyCustomer(user,pass);
}

public BankCustomer searchCustomerByCusID(int cid) throws SQLException {
	return cDao.searchCustomerByCusID(cid);
}

public BankCustomer searchCustomerByAdhar(int cadhar) throws SQLException {
	return cDao.searchCustomerByAdhar(cadhar);
}

public boolean verifyexecUser(String user,String pass)throws SQLException,ClassNotFoundException{
	return cDao.verifyexecUser(user, pass);
}

public boolean updateUser(BankCustomer cst) throws SQLException{
	return cDao.updateUser( cst);
}

public List<BankCustomer> showCustomers() throws SQLException{
	return cDao.showCustomers();
}
public boolean createAccount(Account acc) throws SQLException {
	return cDao.createAccount(acc);
}
public int getAdhar(int cid) throws SQLException {
	return cDao.getadhar(cid);
}

public boolean deleteCustomer(int cid) throws SQLException {
	return cDao.deleteCustomer(cid);
}
public Account searchAccountByAccID(int Aid) throws SQLException {
	return cDao.searchAccountByAccID(Aid);
}
public boolean deleteAccount(int Aid) throws SQLException {
	return cDao.deleteAccount(Aid);
}
public Account depositBalance(int Aid,int upbal) throws SQLException {
	return cDao.depositBalance(Aid, upbal);
}
public Account withdrawBalance(int Aid,int upbal) throws SQLException {
	return cDao.withdrawBalance(Aid, upbal);
}
public List<Transaction> showbwtransactionBydates(String date,String date1,int accid) throws SQLException, ParseException{
	return cDao.showbwtransactionBydates(date,date1,accid);
}
public boolean insertintotransaction(Transaction tsa,Account cst, int upbal) throws SQLException {
	return cDao.insertintotransaction(tsa, cst, upbal);
}
public List<Transaction> showbwtransactionBycount(int accid,int num) throws SQLException{
	return cDao.showbwtransactionBycount(accid, num);
}
public List<Integer> showAccountsByCustomerId(int cid) throws SQLException{
	return cDao.showAccountsByCustomerId(cid);
}
public List<Integer> showAccountsByAdharId(int cid) throws SQLException{
	return cDao.showAccountsByAdharId(cid);
}
public List<Account> showAllAccounts() throws SQLException{
	return cDao.showAllAccounts();
}
public boolean verifyAccountByAccID(int Aid) throws SQLException {
	return cDao.verifyAccountByAccID(Aid);
}
public void createTable() throws ClassNotFoundException {}
}