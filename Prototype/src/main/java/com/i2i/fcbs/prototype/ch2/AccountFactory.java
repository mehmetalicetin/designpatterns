package com.i2i.fcbs.prototype.ch2;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;

public class AccountFactory implements Factory{
	private static final Account account =  new Account("1",1000,1000, new Customer("Ali"), true, true, true);
	@Override
	public Account createAccount() {
		return account.clone();
	}

	@Override
	public Account createAccount(Customer customer, double balance) {
		Account newAccount = account.clone();
		newAccount.setBalance(balance);
		newAccount.setCustomer(customer);
		return newAccount;
	}
}
