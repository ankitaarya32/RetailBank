package com.FFFANS.bean;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class BankCustomer {
	
	private int CustomerId;
	private int CustomerAdhar;
	private String Customer_name;
	private int Age;
	private String Address;
	private String City;
	private String State;
	private int AccountId;
	private String Account_type;
	private String status;
	private String message;
	private Date last_update;
	private Time Last_time=Time.valueOf(LocalTime.now());
	public Time getLast_time() {
		return Last_time;
	}
	public void setLast_time(Time last_time) {
		Last_time = last_time;
	}
	public BankCustomer() {
		super();
	}
	
	public BankCustomer(int customerId, int customerAdhar, String customer_name, int age, String address, String city,
			String state, int accountId, String account_type, String status, String message, Date last_update,
			Time last_time) {
		super();
		CustomerId = customerId;
		CustomerAdhar = customerAdhar;
		Customer_name = customer_name;
		Age = age;
		Address = address;
		City = city;
		State = state;
		AccountId = accountId;
		Account_type = account_type;
		this.status = status;
		this.message = message;
		this.last_update = last_update;
		Last_time = last_time;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getCustomerAdhar() {
		return CustomerAdhar;
	}
	public void setCustomerAdhar(int customerAdhar) {
		CustomerAdhar = customerAdhar;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
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
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	
	@Override
	public String toString() {
		return "Bank [CustomerId=" + CustomerId + ", CustomerAdhar=" + CustomerAdhar + ", Customer_name="
				+ Customer_name + ", Age=" + Age + ", Address=" + Address + ", City=" + City + ", State=" + State
				+ ", AccountId=" + AccountId + ", Account_type=" + Account_type + ", status=" + status + ", message="
				+ message + ", last_update=" + last_update + "]";
	}
	
	
}
