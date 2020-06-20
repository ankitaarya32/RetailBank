package com.FFFANS.bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;

public class Account {
	private int CustomerID;
	private int customerAdhar; 
	private int AccountID;
	private String Account_type;
	private String status="Active";
	private String message;
	private int amount;
	
	public Account(int customerID, int customerAdhar, int accountID, String account_type, String status, String message,
			int amount, Date last_updated, Time last_time) {
		super();
		CustomerID = customerID;
		this.customerAdhar = customerAdhar;
		AccountID = accountID;
		Account_type = account_type;
		this.status = status;
		this.message = message;
		this.amount = amount;
		Last_updated = last_updated;
		Last_time = last_time;
	}
	public Account() {
		super();
	}
	public Account(int customerID, String account_type, int amount) {
		super();
		CustomerID = customerID;
		Account_type = account_type;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private Date Last_updated = Date.valueOf(LocalDate.now());
	private Time Last_time=Time.valueOf(LocalTime.now());
	public Time getLast_time() {
		return Last_time;
	}
	public void setLast_time(Time last_time) {
		Last_time = last_time;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public int getCustomerAdhar() {
		return customerAdhar;
	}
	public void setCustomerAdhar(int customerAdhar) {
		this.customerAdhar = customerAdhar;
	}
	public int getAccountID() {
		return AccountID;
	}
	public void setAccountID(int accountID) {
		AccountID = accountID;
	}
	public String getAccount_type() {
		return Account_type;
	}
	public void setAccount_type(String account_type) {
		Account_type = account_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getLast_updated() {
		return Last_updated;
	}
	public void setLast_updated(Date last_updated) {
		Last_updated = last_updated;
	}
	@Override
	public String toString() {
		return "Account [CustomerID=" + CustomerID + ", customerAdhar=" + customerAdhar + ", AccountID=" + AccountID
				+ ", Account_type=" + Account_type + ", status=" + status + ", message=" + message + ", Last_updated="
				+ Last_updated + "]";
	}
	
}
