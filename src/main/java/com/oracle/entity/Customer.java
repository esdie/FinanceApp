package com.oracle.entity;


public class Customer {
	private String customer_id;
	private String first_name;
	private String last_name;
	
	private int contact_no;
	private String email;
	private String gender;
	private String pan_number;
	private int aadhar_number;
	
	
	private String address;
	public Customer(String customer_id, String first_name, String last_name, String address, int contact_no,
			String email, String gender, String pan_number, int aadhar_number) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.contact_no = contact_no;
		this.email = email;
		this.gender = gender;
		this.pan_number = pan_number;
		this.aadhar_number = aadhar_number;
	}
	public Customer() {
		
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public int getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(int aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	
	
	

}
