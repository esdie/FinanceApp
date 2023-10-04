package com.oracle.entity;

import java.sql.Date;
import java.util.UUID;

public class LoanApplication {
	
	private String loan_application_number;
	private String customer_id;
	private int loan_id;
	private String clerk_id;
	private String first_name;
	private String last_name;
	private int  requested_amount;
	private int requested_tenure;
	private Date application_date;
	private String application_status;
	private String branch;
	public LoanApplication(String loan_application_number, String customer_id, int loan_id, String clerk_id,
			String first_name, String last_name, int requested_amount, int requested_tenure, Date application_date,
			String application_status, String branch) {
		super();
		this.loan_application_number = loan_application_number;
		this.customer_id = customer_id;
		this.loan_id = loan_id;
		this.clerk_id = clerk_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.requested_amount = requested_amount;
		this.requested_tenure = requested_tenure;
		this.application_date = application_date;
		this.application_status = application_status;
		this.branch = branch;
	}
	public LoanApplication() {
		
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
	public String getClerk_id() {
		return clerk_id;
	}
	public void setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getRequested_amount() {
		return requested_amount;
	}
	public void setRequested_amount(int requested_amount) {
		this.requested_amount = requested_amount;
	}
	public int getRequested_tenure() {
		return requested_tenure;
	}
	public void setRequested_tenure(int requested_tenure) {
		this.requested_tenure = requested_tenure;
	}
	public Date getApplication_date() {
		return application_date;
	}
	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}
	public String getApplication_status() {
		return application_status;
	}
	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	

}
