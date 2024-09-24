package com.i2i.fcbs.ch1;

import com.i2i.fcbs.prototype.ch1.Account;
import com.i2i.fcbs.prototype.ch1.Customer;

public class Test {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Account normalAccount = new Account("1",1000,1000, new Customer("Ali"), true, true, true);
		System.out.println("Normal account: " + normalAccount);
		Account negativeAccount = new Account("2", -500, -1000, new Customer("Mustafa"), true, true, false);
		System.out.println("Negative account: " + negativeAccount);
		Account frozenAccount = new Account("3", -1000, -1000, new Customer("Metin"), false, false, true);
		System.out.println("Frozen account: " + frozenAccount);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

		//Bazen bu turden karmasik nesneleri sifisrdan yaratmak yerine, elde var olan nesnelerden clone yaparak sadece ilgili kısmı set metodu ile
		//değiştirmek süretiyle ilerlenebilir.
	}
}
