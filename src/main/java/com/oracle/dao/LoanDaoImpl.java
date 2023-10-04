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

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;
import com.oracle.repository.DBConnection;
@Component
public class LoanDaoImpl implements LoanDao {
	
	@Autowired
	DBConnection dbConnection;
	@Override
	public List<Loans> getLoans() {
		Connection con = dbConnection.connect();
		List<Loans> resultList = new ArrayList<>();
		try {
			String sql="select * from loans";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			while( rs.next()) {
				

				Loans loans = new Loans();
				loans.setInterest_rate(rs.getDouble("interest_rate"));
				loans.setLoan_id(rs.getInt("loan_code"));
				loans.setLoan_type(rs.getString("loans_type"));
				

				resultList.add(loans);
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
		return resultList;
	}

	@Override
	public List<LoanApplication> getAllLoanApplication() {
		Connection con=	dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql="select * from loan_application";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				
				LoanApplication loanApplication = new LoanApplication();
				loanApplication.setLoan_application_number(rs.getString("loan_application_number"));
				loanApplication.setCustomer_id(rs.getString("customer_id"));
				loanApplication.setLoan_id(rs.getInt("loan_code"));
				loanApplication.setClerk_id(rs.getString("clerk_id"));
				loanApplication.setFirst_name(rs.getString("first_name"));
				loanApplication.setLast_name(rs.getString("last_name"));
				loanApplication.setRequested_amount(rs.getInt("requested_amount"));
				loanApplication.setRequested_tenure(rs.getInt("requested_tenure"));
				loanApplication.setApplication_date(rs.getDate("application_date"));
				loanApplication.setApplication_status(rs.getString("application_status"));
				loanApplication.setBranch(rs.getString("branch"));
				

				resultList.add(loanApplication);
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
		return resultList;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByDate(String start_date, String end_date) {
		Date startDate = Date.valueOf(start_date);
		Date endDate = Date.valueOf(end_date);
		
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where application_date between ? and ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanApplication loanApplication = new LoanApplication();
				loanApplication.setLoan_application_number(rs.getString("loan_application_number"));
				loanApplication.setCustomer_id(rs.getString("customer_id"));
				loanApplication.setLoan_id(rs.getInt("loan_code"));
				loanApplication.setClerk_id(rs.getString("clerk_id"));
				loanApplication.setFirst_name(rs.getString("first_name"));
				loanApplication.setLast_name(rs.getString("last_name"));
				loanApplication.setRequested_amount(rs.getInt("requested_amount"));
				loanApplication.setRequested_tenure(rs.getInt("requested_tenure"));
				loanApplication.setApplication_date(rs.getDate("application_date"));
				loanApplication.setApplication_status(rs.getString("application_status"));
				loanApplication.setBranch(rs.getString("branch"));
				

				resultList.add(loanApplication);

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
		return resultList;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByNumber(String loan_application_number) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		
		try {
			String sql = "select * from loan_application where loan_application_number =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_application_number);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanApplication loanApplication = new LoanApplication();
				loanApplication.setLoan_application_number(rs.getString("loan_application_number"));
				loanApplication.setCustomer_id(rs.getString("customer_id"));
				loanApplication.setLoan_id(rs.getInt("loan_code"));
				loanApplication.setClerk_id(rs.getString("clerk_id"));
				loanApplication.setFirst_name(rs.getString("first_name"));
				loanApplication.setLast_name(rs.getString("last_name"));
				loanApplication.setRequested_amount(rs.getInt("requested_amount"));
				loanApplication.setRequested_tenure(rs.getInt("requested_tenure"));
				loanApplication.setApplication_date(rs.getDate("application_date"));
				loanApplication.setApplication_status(rs.getString("application_status"));
				loanApplication.setBranch(rs.getString("branch"));
				

				resultList.add(loanApplication);

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
		return resultList;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByType(int loan_code) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where loan_type_code =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, loan_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanApplication loanApplication = new LoanApplication();
				loanApplication.setLoan_application_number(rs.getString("loan_application_number"));
				loanApplication.setCustomer_id(rs.getString("customer_id"));
				loanApplication.setLoan_id(rs.getInt("loan_code"));
				loanApplication.setClerk_id(rs.getString("clerk_id"));
				loanApplication.setFirst_name(rs.getString("first_name"));
				loanApplication.setLast_name(rs.getString("last_name"));
				loanApplication.setRequested_amount(rs.getInt("requested_amount"));
				loanApplication.setRequested_tenure(rs.getInt("requested_tenure"));
				loanApplication.setApplication_date(rs.getDate("application_date"));
				loanApplication.setApplication_status(rs.getString("application_status"));
				loanApplication.setBranch(rs.getString("branch"));
				

				resultList.add(loanApplication);
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
		return resultList;
	}

	@Override
	public LoanApplication applyLoan(LoanApplication a) {
		Connection con=	dbConnection.connect();
		try {
			System.out.println("in here");
			
			String application_number=UUID.randomUUID().toString();	
			
			Date application_date = new Date(System.currentTimeMillis());
			String query="INSERT INTO LOAN_APPLICATION VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,application_number);
			ps.setString(2,a.getCustomer_id());
			ps.setInt(3,a.getLoan_id());
			ps.setString(4,a.getClerk_id());
			ps.setString(5, a.getFirst_name());
			ps.setString(6,a.getLast_name());
			ps.setInt(7,a.getRequested_amount());
			ps.setInt(8, a.getRequested_tenure());
			ps.setDate(9,application_date);
			ps.setString(10, a.getApplication_status());
			ps.setString(11, a.getBranch());
			
			int res=ps.executeUpdate();
			System.out.println("sss"+res);
			a.setApplication_date(application_date);
			a.setLoan_application_number(application_number);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}

}
