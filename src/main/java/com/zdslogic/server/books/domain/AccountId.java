package com.zdslogic.server.books.domain;

import java.io.Serializable;

public class AccountId implements Serializable {
	private String accountNumber;

	private String accountType;

	// default constructor

	public AccountId(String accountNumber, String accountType) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
