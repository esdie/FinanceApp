package com.oracle.entity;
import java.sql.Date;
public class CustomerTransactions {
	private String transaction_id;
	private String loan_account_number;
	private String customer_id;
	private double transaction_amount;
	private Date transaction_date;
	
	public CustomerTransactions(String transaction_id, String loan_account_number, String customer_id,
			double transaction_amount, Date transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.loan_account_number = loan_account_number;
		this.customer_id = customer_id;
		this.transaction_amount = transaction_amount;
		this.transaction_date = transaction_date;
	}
	public CustomerTransactions() {
		
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	@Override
	public String toString() {
		return "CustomerTransactions [transaction_id=" + transaction_id + ", loan_account_number=" + loan_account_number
				+ ", customer_id=" + customer_id + ", transaction_amount=" + transaction_amount + ", transaction_date="
				+ transaction_date + "]";
	}
	
}
