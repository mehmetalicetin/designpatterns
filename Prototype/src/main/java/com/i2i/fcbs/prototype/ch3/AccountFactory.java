package com.i2i.fcbs.prototype.ch3;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;

public class AccountFactory  implements Factory{
	private static final Account account =  new Account("1",1000,1000, new Customer("Ali"), true, true, true);

	@Override
	public Account createAccount() {
		return account.clone();
	}

	@Override
	public Account createNormalAccount(Customer customer, double balance) {
		Account normal = account.clone();
		normal.setBalance(balance);
		normal.setCustomer(customer);
		normal.setOpenToPayment(true);
		normal.setOpenToWithdraw(true);
		normal.setOpenToTransfer(true);
		return normal;
	}

	@Override
	public Account createNegativeAccount(Customer customer, double balance) {
		Account negative = account.clone();
		negative.setBalance(balance);
		negative.setCustomer(customer);
		negative.setOpenToPayment(true);
		negative.setOpenToWithdraw(false);
		negative.setOpenToTransfer(false);
		return negative;
	}

	@Override
	public Account createFrozenAccount(Customer customer, double balance) {
		Account frozen = account.clone();
		frozen.setBalance(balance);
		frozen.setCustomer(customer);
		frozen.setOpenToPayment(false);
		frozen.setOpenToWithdraw(false);
		frozen.setOpenToTransfer(false);
		return frozen;
	}
}
