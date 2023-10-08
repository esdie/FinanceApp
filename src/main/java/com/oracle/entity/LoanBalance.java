package com.oracle.entity;

public class LoanBalance {
	private double principal_paid;
	private double interest_paid;
	private String loan_account_number;
	private String customer_id;
	private double outstanding_balance;
	private int tenure_remaining;
	private double interest_rate;
	private double current_principal;
	
	@Override
	public String toString() {
		return "LoanBalance [principal_paid=" + principal_paid + ", interest_paid=" + interest_paid
				+ ", loan_account_number=" + loan_account_number + ", customer_id=" + customer_id
				+ ", outstanding_balance=" + outstanding_balance + ", tenure_remaining=" + tenure_remaining
				+ ", interest_rate=" + interest_rate + ", current_principal=" + current_principal + "]";
	}
	public LoanBalance() {
		
	}
	public LoanBalance(double principal_paid, double interest_paid, String loan_account_number, String customer_id,
			double outstanding_balance, int tenure_remaining, double interest_rate, double current_principal) {
		super();
		this.principal_paid = principal_paid;
		this.interest_paid = interest_paid;
		this.loan_account_number = loan_account_number;
		this.customer_id = customer_id;
		this.outstanding_balance = outstanding_balance;
		this.tenure_remaining = tenure_remaining;
		this.interest_rate = interest_rate;
		this.current_principal = current_principal;
	}
	public double getPrincipal_paid() {
		return principal_paid;
	}
	public void setPrincipal_paid(double principal_paid) {
		this.principal_paid = principal_paid;
	}
	public double getInterest_paid() {
		return interest_paid;
	}
	public void setInterest_paid(double interest_paid) {
		this.interest_paid = interest_paid;
	}
	public String getLoan_account_number() {
		return loan_account_number;
	}
	public void setLoan_account_number(String loan_account_number) {
		this.loan_account_number = loan_account_number;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public double getOutstanding_balance() {
		return outstanding_balance;
	}
	public void setOutstanding_balance(double outstanding_balance) {
		this.outstanding_balance = outstanding_balance;
	}
	public int getTenure_remaining() {
		return tenure_remaining;
	}
	public void setTenure_remaining(int tenure_remaining) {
		this.tenure_remaining = tenure_remaining;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public double getCurrent_principal() {
		return current_principal;
	}
	public void setCurrent_principal(double current_principal) {
		this.current_principal = current_principal;
	}
}
