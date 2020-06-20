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
		
		public Transaction() {
			super();
		}
		public Transaction(int customerId, int soureAccountId, String sourceAccountType, int targetAccountId,
				String targetAccountType, String transDesc, int transactionId, int amount, Date last_updated,
				Time last_time) {
			super();
			CustomerId = customerId;
			SoureAccountId = soureAccountId;
			SourceAccountType = sourceAccountType;
			TargetAccountId = targetAccountId;
			TargetAccountType = targetAccountType;
			TransDesc = transDesc;
			TransactionId = transactionId;
			this.amount = amount;
			Last_updated = last_updated;
			Last_time = last_time;
		}
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
		@Override
		public String toString() {
			return "Transaction [CustomerId=" + CustomerId + ", SoureAccountId=" + SoureAccountId
					+ ", SourceAccountType=" + SourceAccountType + ", TargetAccountId=" + TargetAccountId
					+ ", TargetAccountType=" + TargetAccountType + ", TransDesc=" + TransDesc + ", TransactionId="
					+ TransactionId + ", amount=" + amount + ", Last_updated=" + Last_updated + ", Last_time="
					+ Last_time + "]";
		}
		
}
