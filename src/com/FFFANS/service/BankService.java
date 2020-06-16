package com.FFFANS.service;

import java.sql.SQLException;
import java.util.List;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.BankCustomer;
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
}