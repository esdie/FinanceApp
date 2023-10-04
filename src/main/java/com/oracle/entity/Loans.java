package com.oracle.entity;

public class Loans {
	private int loan_id;
	private String loan_type;
	private double interest_rate ;
	public Loans(int loan_id, String loan_type, double interest_rate) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.interest_rate = interest_rate;
	}
	public Loans(){
		
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	
	
}
