package com.oracle.entity;
import java.sql.Date;
public class LoanAccount {
	private String loan_account_number;
	private String loan_application_number;
	private String customer_id;
	private int loan_id;
	private double loan_amount_sanctioned;
	private String loan_status;
	private double emi;
	private double disbursed_amount;
	private int loan_tenure;
	private Date approval_date;
	public LoanAccount() {
		
	}
	public String getLoan_account_number() {
		return loan_account_number;
	}
	public void setLoan_account_number(String loan_account_number) {
		this.loan_account_number = loan_account_number;
	}
	public String getLoan_application_number() {
		return loan_application_number;
	}
	public void setLoan_application_number(String loan_application_number) {
		this.loan_application_number = loan_application_number;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public double getLoan_amount_sanctioned() {
		return loan_amount_sanctioned;
	}
	public void setLoan_amount_sanctioned(double loan_amount_sanctioned) {
		this.loan_amount_sanctioned = loan_amount_sanctioned;
	}
	public String getLoan_status() {
		return loan_status;
	}
	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public double getDisbursed_amount() {
		return disbursed_amount;
	}
	public void setDisbursed_amount(double disbursed_amount) {
		this.disbursed_amount = disbursed_amount;
	}
	public int getLoan_tenure() {
		return loan_tenure;
	}
	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
	}
	public Date getApproval_date() {
		return approval_date;
	}
	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}
	
}
