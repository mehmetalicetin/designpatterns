package com.i2i.fcbs.ch3;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;
import com.i2i.fcbs.prototype.ch3.AccountFactory;
import com.i2i.fcbs.prototype.ch3.Factory;

public class Test {
	public static void main(String[] args) {
		Factory factory = new AccountFactory();
		Account account = factory.createAccount();
		System.out.println(account);

		Account normal = factory.createNormalAccount(new Customer("Ali"), 10000);
		System.out.println(normal);

		Account negative = factory.createNegativeAccount(new Customer("Metin"), -10000);
		System.out.println(negative);


		Account frozen = factory.createFrozenAccount(new Customer("Zeynep"), -10000);
		System.out.println(frozen);

	}
}
