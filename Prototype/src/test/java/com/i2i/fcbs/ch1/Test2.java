package com.i2i.fcbs.ch1;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;

public class Test2 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Account defaultAccount = new Account("1",1000,1000, new Customer("Ali"), true, true, true);

		Account normalAccount = defaultAccount.clone();
		normalAccount.setIban("2");
		normalAccount.setBalance(2000);
		normalAccount.setCustomer(new Customer("Remzi"));
		System.out.println("Normal Account: " + normalAccount);



		Account negativeAccount = defaultAccount.clone();
		negativeAccount.setIban("3");
		negativeAccount.setBalance(-2000);
		negativeAccount.setCustomer(new Customer("Ismail"));
		negativeAccount.setOpenToPayment(false);
		negativeAccount.setOpenToWithdraw(false);
		negativeAccount.setOpenToTransfer(false);
		System.out.println("Negative Account: " + negativeAccount);

		Account positiveAccount = defaultAccount.clone();
		positiveAccount.setIban("4");
		positiveAccount.setBalance(2000);
		positiveAccount.setCustomer(new Customer("Mike"));
		positiveAccount.setOpenToPayment(true);
		positiveAccount.setOpenToWithdraw(true);
		positiveAccount.setOpenToTransfer(true);
		System.out.println("Positive Account: " + positiveAccount);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

		//
	}
}
