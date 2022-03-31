package com.natwest.queue.sender.dto;

import java.io.Serializable;

public class TransactionDTO implements Serializable {


	private static final long serialVersionUID = -740561235512194513L;
	private long accountNumber;
	private String transactionType;
	private double amount;
	private String currency;
	private long accountFrom;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(long accountFrom) {
		this.accountFrom = accountFrom;
	}
	
}
