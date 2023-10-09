package com.oracle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanApplication;
import com.oracle.entity.LoanBalance;
import com.oracle.entity.Loans;
import com.oracle.exception.LoanApplicationException;
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
		

		System.out.println(start_date);
		System.out.println(end_date);
		Date startDate = Date.valueOf(start_date);
		Date endDate = Date.valueOf(end_date);
		System.out.println("After change: "+startDate+" "+endDate);
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		System.out.println("dao me");
		try {
			String sql = "select * from loan_application where application_date between ? and ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, startDate);
			pstmt.setDate(2, endDate);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Query");
			while(rs.next()) {
				System.out.println("result k andar");
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
System.out.println(resultList.size());
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
	public LoanApplication searchLoanApplicationByNumber(String loan_application_number) {
		Connection con = dbConnection.connect();
		LoanApplication loanApplication = null;
		
		try {
			String sql = "select * from loan_application where loan_application_number =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_application_number);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				loanApplication = new LoanApplication();
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
		return loanApplication;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByType(int loan_code) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where loan_code =?";
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
	public LoanApplication applyLoan(LoanApplication application) {
		Connection con=	dbConnection.connect();
		try {
			System.out.println("in here");
			System.out.println(application.getClerk_id());
			String application_number=UUID.randomUUID().toString();	
			//System.out.println("uuid: "+application.getLoan_application_number());
			Date application_date = new Date(System.currentTimeMillis());
			String query="INSERT INTO LOAN_APPLICATION VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,application_number);
			ps.setString(2,application.getCustomer_id());
			ps.setInt(3,application.getLoan_id());
			ps.setString(4,application.getClerk_id());
			ps.setString(5, application.getFirst_name());
			ps.setString(6,application.getLast_name());
			ps.setInt(7,application.getRequested_amount());
			ps.setInt(8, application.getRequested_tenure());
			ps.setDate(9,application_date);
			ps.setString(10, "PENDING");
			ps.setString(11, application.getBranch());
			
			int res=ps.executeUpdate();
		
			System.out.println("sss"+res);
			application.setApplication_date(application_date);
			application.setLoan_application_number(application_number);
			
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
		return application;
	}

	@Override
	public List<LoanApplication> cancelLoanApplication(String loan_application_number) {
		Connection con=	dbConnection.connect();
		List<LoanApplication> result = null;
		try {
			String query="DELETE FROM LOAN_APPLICATION WHERE LOAN_APPLICATION_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,loan_application_number);
			int res=ps.executeUpdate();
			if(res ==0) {
				throw new LoanApplicationException();
			}
			result = getAllLoanApplication();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public LoanAccount makeLoanAccount(LoanApplication loan_application, double amount_sanctioned, int tenure, double interest_rate) {
		LoanAccount account = null;
		Connection con=	dbConnection.connect();
		try {
			account = new LoanAccount();
			String account_number=UUID.randomUUID().toString();
			Date application_date = new Date(System.currentTimeMillis());
			String query="INSERT INTO LOAN_ACCOUNT VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,account_number);
			account.setLoan_account_number(account_number);
			ps.setString(2,loan_application.getLoan_application_number());
			account.setLoan_application_number(loan_application.getLoan_application_number());
			ps.setString(3, loan_application.getCustomer_id());
			account.setCustomer_id(loan_application.getCustomer_id());
			ps.setInt(4,loan_application.getLoan_id());
			account.setLoan_id(loan_application.getLoan_id());
			ps.setDouble(5, amount_sanctioned);
			account.setLoan_amount_sanctioned(amount_sanctioned);
			ps.setString(6, "ONGOING");
			account.setLoan_status("ONGOING");
			double r = interest_rate;
			double n = tenure;
			r = r/100;
			r = r / 12;
			double emi = (amount_sanctioned * r *((Math.pow(1 + r, n))/((Math.pow((1 + r), n) - 1))));
			ps.setDouble(7, emi);
			account.setEmi(emi);
			ps.setDouble(8, amount_sanctioned);
			account.setDisbursed_amount(amount_sanctioned);
			ps.setInt(9,tenure);
			account.setLoan_tenure(tenure);
			ps.setDate(10, application_date);
			account.setApproval_date(application_date);
			ps.setDouble(11, interest_rate);
			account.setInterest_rate(interest_rate);
			int res=ps.executeUpdate();
			System.out.println("customer id:");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return account;
	}
	@Override
	public List<LoanApplication> rejectLoanApplication(String loan_application_number) {
		Connection con=	dbConnection.connect();
		List<LoanApplication> result = null;
		try {
			
			String query="UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = 'REJECTED' WHERE LOAN_APPLICATION_NUMBER = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, loan_application_number);
			int res=ps.executeUpdate();
			if(res ==0) {
				throw new LoanApplicationException();
			}
			result = getAllLoanApplication();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<LoanApplication> approveLoanApplication(String loan_application_number, double amount_sanctioned, int tenure) {
		Connection con = null;
		List<LoanApplication> result = null;
		
		try {
			con = dbConnection.connect();
			String query="UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = 'APPROVED' WHERE LOAN_APPLICATION_NUMBER = ? AND APPLICATION_STATUS = 'PENDING'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, loan_application_number);
			int res=ps.executeUpdate();
			System.out.println("res: "+res);
			if(res ==0) {
				throw new LoanApplicationException("Could not approve");
			}
			LoanApplication appl = searchLoanApplicationByNumber(loan_application_number);
			double interest_rate = getInterestRate(appl.getLoan_id());
			LoanAccount acc = makeLoanAccount(appl, amount_sanctioned, tenure, interest_rate);
			System.out.println(acc);
			LoanBalance bal = insertIntoLoanBalance(acc, interest_rate);
			System.out.println(bal);
			result = getAllLoanApplication();
		} catch (Exception e) {
			System.out.println(e);
			throw new LoanApplicationException(" Could not approve");
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public LoanBalance insertIntoLoanBalance(LoanAccount loan_account, double interest_rate) {
		Connection con = null;
		try {
			LoanBalance bal = new LoanBalance();
			con = dbConnection.connect();
			String query="insert into loan_balance values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, 0);
			bal.setPrincipal_paid(0);
			ps.setDouble(2, 0);
			bal.setInterest_paid(0);
			ps.setString(3, loan_account.getLoan_account_number());
			bal.setLoan_account_number(loan_account.getLoan_account_number());
			ps.setString(4,  loan_account.getCustomer_id());
			bal.setCustomer_id(loan_account.getCustomer_id());
			double outstanding_balance = loan_account.getEmi() * loan_account.getLoan_tenure();
			ps.setDouble(5, outstanding_balance);
			bal.setOutstanding_balance(outstanding_balance);
			ps.setInt(6, loan_account.getLoan_tenure());
			bal.setTenure_remaining(loan_account.getLoan_tenure());
			ps.setDouble(7, interest_rate);
			bal.setInterest_rate(interest_rate);
			ps.setDouble(8, loan_account.getLoan_amount_sanctioned());
			bal.setCurrent_principal(loan_account.getLoan_amount_sanctioned());
			int res=ps.executeUpdate();
			System.out.println(" loan balance: "+res);
			if(res ==0) {
				throw new LoanApplicationException("Could not make loan balance");
			}
			System.out.println("balance: "+bal);
			return bal;
		} catch (Exception e) {
			System.out.println(e);
			throw new LoanApplicationException(" Could not make loan balance");
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByCustomer(String customer_id) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where customer_id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
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
				//System.out.println("loanApplication "+loanApplication);

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
		//System.out.println("size: "+resultList.size());
		return resultList;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByStatus(String loan_status) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where application_status = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_status);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println(rs.next());
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
		System.out.println(resultList.size());
		return resultList;
	}

	@Override
	public List<LoanApplication> searchLoanApplicationByClerkId(String clerk_id) {
		Connection con = dbConnection.connect();
		List<LoanApplication> resultList = new ArrayList<>();
		try {
			String sql = "select * from loan_application where clerk_id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clerk_id);
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
	public double getInterestRate(int loan_id) {
		double interest_rate = 0;
		Connection con=	dbConnection.connect();
		try {
			String sql="select interest_rate from loans where loan_code = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, loan_id);
			ResultSet rs= pstmt.executeQuery();
			//System.out.println("connected.. + executed");
			while( rs.next()) {
				interest_rate = rs.getDouble("interest_rate");
				System.out.println("interest: "+ interest_rate);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoanApplicationException("Could not get rate of interest");
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return interest_rate;
	}
	
		
	
}
