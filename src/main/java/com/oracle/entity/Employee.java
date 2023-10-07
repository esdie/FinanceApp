package com.oracle.entity;

public class Employee {
	private String employee_id;
	private String first_name;
	private String last_name;
	private String gender;
	private long contact_no;
	private String email;
	private String employee_type;
	private String branch ;
	public Employee(String employee_id, String first_name, String last_name, String gender, int contact_no,
			String email, String employee_type, String branch) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.contact_no = contact_no;
		this.email = email;
		this.employee_type = employee_type;
		this.branch = branch;
	}
	public Employee() {
		
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	

}
