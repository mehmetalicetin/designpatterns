package com.i2i.fcbs.prototype.ch2;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;

public interface Factory {
	Account createAccount();
	Account createAccount(Customer customer, double balance);
}
