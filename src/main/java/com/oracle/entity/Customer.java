package com.oracle.entity;


public class Customer {
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", contact_no=" + contact_no + ", email=" + email + ", gender=" + gender + ", pan_number="
				+ pan_number + ", aadhar_number=" + aadhar_number + ", username=" + username + ", address=" + address
				+ "]";
	}
	private String customer_id;
	private String first_name;
	private String last_name;
	
	private long contact_no;
	private String email;
	private String gender;
	private String pan_number;
	private String aadhar_number;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String address;
	public Customer(String customer_id, String first_name, String last_name, String address, int contact_no,
			String email, String gender, String pan_number, String aadhar_number, String username) {
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
		this.username = username;
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
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
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
	public String getAadhar_number() {
		return aadhar_number;
	}
	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}
	
	
	

}
