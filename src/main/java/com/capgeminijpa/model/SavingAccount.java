package com.capgeminijpa.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="sa")
public class SavingAccount extends Account{
	private long minBalance;
	private long accountId;
	public SavingAccount() {
		
	}
	public long getMinBalance() {
		return minBalance;
	}
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setMinBalance(long minBalance) {
		this.minBalance = minBalance;
	}
}
