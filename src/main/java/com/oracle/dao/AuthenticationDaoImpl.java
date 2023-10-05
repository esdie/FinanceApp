package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Users;
import com.oracle.exception.LoanApplicationException;
import com.oracle.repository.DBConnection;

@Component
public class AuthenticationDaoImpl implements AuthenticationDao {
	
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
			exists = rs.next();
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
		try {
			if(!userExists(username)) {
				throw new LoanApplicationException("User Does not exists");
			}
			String sql = "select * from users where username =? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				role = rs.getString("role");
			}
			else {
				throw new LoanApplicationException("Wrong Credentials");
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
		return role;
	}

}
