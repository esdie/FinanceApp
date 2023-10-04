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
import com.oracle.entity.Loans;
import com.oracle.repository.DBConnection;
@Component
public class LoanDaoImpl implements LoanDao {
	
	@Autowired
	DBConnection dbConnection;
	@Override
	public List<Loans> getLoans() {
		
		return null;
	}

	@Override
	public List<LoanApplication> getAllLoanApplication() {
		Connection con=	dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		System.out.println("In getALl");
		try {
			String sql="select * from loan_application";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				

				LoanApplication loanApplication = new LoanApplication();
				loanApplication.setLoan_application_number(rs.getString(1));
				loanApplication.setCustomer_id(rs.getString(2));
				loanApplication.setLoan_id(rs.getInt(3));
				loanApplication.setClerk_id(rs.getString(4));
				loanApplication.setFirst_name(rs.getString(5));
				loanApplication.setLast_name(rs.getString(6));
				loanApplication.setRequested_amount(rs.getInt(7));
				loanApplication.setRequested_tenure(rs.getInt(8));
				loanApplication.setApplication_date(rs.getDate(9));
				loanApplication.setApplication_status(rs.getString(10));
				loanApplication.setBranch(rs.getString(11));
				

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByNumber(String loan_application_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByType(int type_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanApplication applyLoan(LoanApplication a) {
		// TODO Auto-generated method stub
		return null;
	}

}
