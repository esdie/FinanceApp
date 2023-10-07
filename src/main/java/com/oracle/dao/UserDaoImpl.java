package com.oracle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.entity.Customer;
import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanApplication;
import com.oracle.entity.Users;
import com.oracle.exception.LoanApplicationException;
import com.oracle.repository.DBConnection;

@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	DBConnection dbConnection;
	public boolean userExists(String username) {
		Connection con = dbConnection.connect();
		boolean exists = false;
		try {
			String sql = "select * from users where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return exists;
	}
	@Override
	public String login(String username, String password) {
		Connection con = dbConnection.connect();
		String role = null;
		String user = "";
		try {
			if(!userExists(username)) {
				throw new LoanApplicationException("Invalid Username/Password");
			}
			String sql = "select * from users where username =? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				role = rs.getString("role");
				user = rs.getString("username");
				return role + " "+ user;
			}
			else {
				throw new LoanApplicationException("Invalid Username/Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean checkCustomer(String username) {
		Connection con = dbConnection.connect();
		boolean exists = false;
		try {
			String sql = "select * from customer where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			exists = rs.next();
			System.out.println(exists);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return exists;
	}
	@Override
	public Customer register(Customer customer, String username, String password) {
		try {
			boolean val = checkCustomer(customer.getUsername());
			System.out.println("val: "+val);
			if(val) {
				throw new LoanApplicationException("Customer Already exists");
			}
			else {
				Connection con = null;
				String cust_id = UUID.randomUUID().toString();
				try {
					con = dbConnection.connect();
					String sql = "insert into users values(?, ?, ?, ?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.setString(3, "customer");
					pstmt.setString(4, cust_id);
					int res = pstmt.executeUpdate();
				}	
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
				try{
					con = dbConnection.connect();
					System.out.println(customer);
					String sql = "insert into customer values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cust_id);
					customer.setCustomer_id(cust_id);
					pstmt.setString(2, customer.getFirst_name());
					pstmt.setString(3, customer.getLast_name());
					pstmt.setString(4, customer.getAddress());
					pstmt.setLong(5, customer.getContact_no());
					pstmt.setString(6, customer.getEmail());
					pstmt.setString(7, customer.getGender());
					pstmt.setString(8, customer.getPan_number());
					pstmt.setString(9, customer.getAadhar_number());
					pstmt.setString(10,  customer.getUsername());
					int res=pstmt.executeUpdate();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						con.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoanApplicationException(e.getMessage());
		}
		
		return customer;
	}
	@Override
	public String getUserMemberId(String username) {
		Connection con = dbConnection.connect();
		String memberId = null;
		try {
			
			String sql = "select member_id from users where username =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberId = rs.getString("member_id");
			}
			else {
				throw new LoanApplicationException("Invalid Credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberId;
	}
	@Override
	public boolean updateUserEmail(String email, String member_id, String role) {
		Connection con = dbConnection.connect();
		try {
			String sql ="";
			if(role.equals("customer")) {
				sql = "update customer set email = ? where customer_id = ?";
			}
			else {
				sql = "update employee set email = ? where employee_id = ?";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, member_id);
			int count = pstmt.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				return true;
			}
			else {
				throw new LoanApplicationException("Invalid Credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public boolean updateUserContact(long contact, String member_id, String role) {
		Connection con = dbConnection.connect();
		try {
			String sql ="";
			if(role.equals("customer")) {
				sql = "update customer set contact_no = ? where customer_id = ?";
			}
			else {
				sql = "update employee set contact_no = ? where employee_id = ?";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, contact);
			pstmt.setString(2, member_id);
			int count = pstmt.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				return true;
			}
			else {
				throw new LoanApplicationException("Invalid Credentials");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public boolean updateUserPassword(String password, String member_id) {
		Connection con = dbConnection.connect();
		try {
			String sql = "update users set password = ? where member_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, member_id);
			int count = pstmt.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				return true;
			}
			else {
				throw new LoanApplicationException("Password could not be updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public Customer getCustomerFromUsername(String username) {
		Customer customer = null;
		Connection con = dbConnection.connect();
		try {
			String sql = "select * from customer where username = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				customer = new Customer();
				customer.setCustomer_id(rs.getString("customer_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setAddress(rs.getString("address"));
				customer.setContact_no(rs.getLong("contact_no"));
				customer.setEmail(rs.getString("email"));
				customer.setGender(rs.getString("gender"));
				customer.setPan_number(rs.getString("pan_number"));
				customer.setAadhar_number("aadhar_number");
				customer.setUsername("username");
			}
			if(customer == null){
				throw new LoanApplicationException("Could not find customer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}

}
