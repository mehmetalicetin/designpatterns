package com.i2i.fcbs.ch2;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;
import com.i2i.fcbs.prototype.ch2.AccountFactory;
import com.i2i.fcbs.prototype.ch2.Factory;

public class Test {
	public static void main(String[] args) {
		Factory factory = new AccountFactory();
		Account normalAccount = factory.createAccount();
		normalAccount.setOpenToTransfer(true);
		normalAccount.setOpenToWithdraw(true);
		normalAccount.setOpenToPayment(true);
		System.out.println(normalAccount);

		Account negative = factory.createAccount(new Customer("Ali"), -10000);
		negative.setOpenToTransfer(true);
		negative.setOpenToWithdraw(false);
		negative.setOpenToPayment(false);
		System.out.println(negative);

	}
}
