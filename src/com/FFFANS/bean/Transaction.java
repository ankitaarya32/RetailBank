package com.FFFANS.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
private int CustomerId;
private int SoureAccountId;
private String SourceAccountType;
private int TargetAccountId;
private String TargetAccountType;
private String TransDesc;
private int TransactionId;
private int amount;
private Date Last_updated = Date.valueOf(LocalDate.now());
private Time Last_time=Time.valueOf(LocalTime.now());
public int getCustomerId() {
	return CustomerId;
}
public void setCustomerId(int customerId) {
	CustomerId = customerId;
}
public int getSoureAccountId() {
	return SoureAccountId;
}
public void setSoureAccountId(int soureAccountId) {
	SoureAccountId = soureAccountId;
}
public String getSourceAccountType() {
	return SourceAccountType;
}
public void setSourceAccountType(String sourceAccountType) {
	SourceAccountType = sourceAccountType;
}
public int getTargetAccountId() {
	return TargetAccountId;
}
public void setTargetAccountId(int targetAccountId) {
	TargetAccountId = targetAccountId;
}
public String getTargetAccountType() {
	return TargetAccountType;
}
public void setTargetAccountType(String targetAccountType) {
	TargetAccountType = targetAccountType;
}
public String getTransDesc() {
	return TransDesc;
}
public void setTransDesc(String transDesc) {
	TransDesc = transDesc;
}
public int getTransactionId() {
	return TransactionId;
}
public void setTransactionId(int transactionId) {
	TransactionId = transactionId;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public Date getLast_updated() {
	return Last_updated;
}
public void setLast_updated(Date last_updated) {
	Last_updated = last_updated;
}
public Time getLast_time() {
	return Last_time;
}
public void setLast_time(Time last_time) {
	Last_time = last_time;
}

}
