package com.i2i.fcbs.prototype.ch1;

// yeni nesneleri belli durumlara sahip olan nesnelerden koplayarak yaratırız.
public class Account implements Cloneable{
	private String iban;
	private double balance;
	private double creditLimit;
	private Customer customer;

	private boolean openToWithdraw;
	private boolean openToPayment;
	private boolean openToTransfer;

	public Account(String iban, double balance, double creditLimit, Customer customer, boolean openToWithdraw, boolean openToPayment,
			boolean openToTransfer) {
		this.iban = iban;
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.customer = customer;
		this.openToWithdraw = openToWithdraw;
		this.openToPayment = openToPayment;
		this.openToTransfer = openToTransfer;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isOpenToWithdraw() {
		return openToWithdraw;
	}

	public void setOpenToWithdraw(boolean openToWithdraw) {
		this.openToWithdraw = openToWithdraw;
	}

	public boolean isOpenToPayment() {
		return openToPayment;
	}

	public void setOpenToPayment(boolean openToPayment) {
		this.openToPayment = openToPayment;
	}

	public boolean isOpenToTransfer() {
		return openToTransfer;
	}

	public void setOpenToTransfer(boolean openToTransfer) {
		this.openToTransfer = openToTransfer;
	}

	@Override
	public String toString() {
		return "Account{" +
				"iban='" + iban + '\'' +
				", balance=" + balance +
				", creditLimit=" + creditLimit +
				", customer=" + customer +
				", openToWithdraw=" + openToWithdraw +
				", openToPayment=" + openToPayment +
				", openToTransfer=" + openToTransfer +
				'}';
	}

	@Override
	public Account clone(){
		Account account = null;
		try{
			account = (Account)super.clone();
		}catch (CloneNotSupportedException e){
			System.err.println("Problem when cloning Account  "+e.getMessage());
			e.printStackTrace();
		}
		return account;
	}

}
