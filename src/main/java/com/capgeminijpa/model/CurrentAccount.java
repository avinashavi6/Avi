package com.capgeminijpa.model;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
//@DiscriminatorValue(value="ca")
public class CurrentAccount extends Account
{
	private long accountId;
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	private String companyName;

	public CurrentAccount() {
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
