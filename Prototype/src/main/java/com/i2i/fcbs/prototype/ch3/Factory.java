package com.i2i.fcbs.prototype.ch3;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;
import com.i2i.fcbs.prototype.ch2.AccountFactory;

public interface Factory {
	Account createAccount();
	Account createNormalAccount(Customer customer, double balance);
	Account createNegativeAccount(Customer customer, double balance);
	Account createFrozenAccount(Customer customer, double balance);
}
