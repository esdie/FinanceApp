package com.oracle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oracle.entity.CustomerTransactions;
import com.oracle.entity.LoanAccount;
import com.oracle.entity.LoanApplication;
import com.oracle.entity.LoanBalance;
import com.oracle.exception.LoanApplicationException;
import com.oracle.repository.DBConnection;

@Component
public class LoanAccountDaoImpl implements  LoanAccountDao{

	@Autowired
	DBConnection dbConnection;
	@Override
	public List<CustomerTransactions> getAllTransactionsForCustomer(String customer_id) {
		Connection con=	dbConnection.connect();
		List<CustomerTransactions> resultList = new ArrayList<>();
		try {
			String sql="select * from customer_transactions where customer_id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				//String transaction_id = UUID.randomUUID().toString();
				CustomerTransactions customerTransactions = new CustomerTransactions();
				
				customerTransactions.setTransaction_id(rs.getString("transaction_id"));
				customerTransactions.setLoan_account_number(rs.getString("loan_account_number"));
				customerTransactions.setCustomer_id(rs.getString("customer_id"));
				customerTransactions.setTransaction_amount(rs.getDouble("transaction_amount"));
				customerTransactions.setTransaction_date(rs.getDate("transaction_date"));
				
				resultList.add(customerTransactions);
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
	public List<CustomerTransactions> getAllTransactionsForAccount(String loan_account_number) {
		Connection con=	dbConnection.connect();
		List<CustomerTransactions> resultList = new ArrayList<>();
		try {
			String sql="select * from customer_transactions where loan_account_number = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				//String transaction_id = UUID.randomUUID().toString();
				CustomerTransactions customerTransactions = new CustomerTransactions();
				
				customerTransactions.setTransaction_id(rs.getString("transaction_id"));
				customerTransactions.setLoan_account_number(rs.getString("loan_account_number"));
				customerTransactions.setCustomer_id(rs.getString("customer_id"));
				customerTransactions.setTransaction_amount(rs.getDouble("transaction_amount"));
				customerTransactions.setTransaction_date(rs.getDate("transaction_date"));
				
				resultList.add(customerTransactions);
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
	public List<LoanAccount> getAllLoanAccounts(String customer_id) {
		Connection con=	dbConnection.connect();
		List<LoanAccount> resultList = new ArrayList<>();
		try {
			String sql="select * from loan_account where customer_id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				
				LoanAccount loanAccount = new LoanAccount();
				loanAccount.setLoan_account_number(rs.getString("loan_account_number"));
				loanAccount.setLoan_application_number(rs.getString("loan_application_number"));
				loanAccount.setCustomer_id(rs.getString("customer_id"));
				loanAccount.setLoan_id(rs.getInt("loan_code"));
				loanAccount.setLoan_amount_sanctioned(rs.getDouble("loan_amount_sanctioned"));
				loanAccount.setLoan_status(rs.getString("loan_status"));
				loanAccount.setEmi(rs.getDouble("emi"));
				loanAccount.setDisbursed_amount(rs.getDouble("disbursed_amount"));
				loanAccount.setLoan_tenure(rs.getInt("loan_tenure"));
				loanAccount.setApproval_date(rs.getDate("approval_date"));
				loanAccount.setInterest_rate(rs.getDouble("interest_rate"));
				

				resultList.add(loanAccount);
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
	public LoanAccount getAllLoanAccountByNumber(String loan_account_number) {
		Connection con=	dbConnection.connect();
		LoanAccount loanAccount = null;
		try {
			String sql="select * from loan_account where loan_account_number = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				
				loanAccount = new LoanAccount();
				loanAccount.setLoan_account_number(rs.getString("loan_account_number"));
				loanAccount.setLoan_application_number(rs.getString("loan_application_number"));
				loanAccount.setCustomer_id(rs.getString("customer_id"));
				loanAccount.setLoan_id(rs.getInt("loan_code"));
				loanAccount.setLoan_amount_sanctioned(rs.getDouble("loan_amount_sanctioned"));
				loanAccount.setLoan_status(rs.getString("loan_status"));
				loanAccount.setEmi(rs.getDouble("emi"));
				loanAccount.setDisbursed_amount(rs.getDouble("disbursed_amount"));
				loanAccount.setLoan_tenure(rs.getInt("loan_tenure"));
				loanAccount.setApproval_date(rs.getDate("approval_date"));
				loanAccount.setInterest_rate(rs.getDouble("interest_rate"));
				
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
		return loanAccount;
	}
	public boolean insertTransaction(String loan_account_number, double amount, String customer_id) {
		Connection con = dbConnection.connect();
		boolean result = false;
		try {
			CustomerTransactions transaction = new CustomerTransactions()
;			String sql = "insert into customer_transactions values(?, ?, ?, ?, ?)";
			String transaction_id = UUID.randomUUID().toString();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, transaction_id);
			transaction.setTransaction_id(transaction_id);
			pstmt.setString(2, loan_account_number);
			transaction.setLoan_account_number(loan_account_number);
			pstmt.setString(3, customer_id);
			transaction.setCustomer_id(customer_id);
			pstmt.setDouble(4, amount);
			transaction.setTransaction_amount(amount);
			Date transaction_date =  new Date(System.currentTimeMillis());
			pstmt.setDate(5, transaction_date );
			transaction.setTransaction_date(transaction_date);
			int res = pstmt.executeUpdate();
			System.out.println("Transaction: "+transaction);
			if(res == 0) {
				throw new LoanApplicationException("Could not perform transaction");
			}
			else {
				result = true;
			}
			
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
		return result;
	}
	public String getCustomerId(String loan_account_number) {
		Connection con = dbConnection.connect();
		String customer_id = null;
		try {
			String sql = "select customer_id from loan_account where loan_account_number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				customer_id = rs.getString("customer_id");
			}
			if(customer_id == null) {
				throw new LoanApplicationException("Customer does not exist");
			}
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
		return customer_id;
	}

	@Override
	public boolean makeTransaction(String loan_account_number, double amount) {
		boolean res = false;
		String customer_id = getCustomerId(loan_account_number);
		double outstanding_balance = getOutstandingBalance(loan_account_number);
		if(outstanding_balance - amount < 0) {
			throw new LoanApplicationException("Amount cannot be greater than total payment");
		}
		boolean insertFlag = insertTransaction(loan_account_number, amount, customer_id);
		if(!insertFlag) {
			throw new LoanApplicationException("Could not make transaction");
		}
		else {
			boolean updateBalance = updateLoanBalance(loan_account_number, amount);
			if(!updateBalance) {
				throw new LoanApplicationException("Could not update loan balance");
			}
			LoanBalance loanBalance = getLoanBalance(loan_account_number);
			boolean loanAccountFlag = updateLoanAccount(loanBalance);
			if(!loanAccountFlag) {
				throw new LoanApplicationException("Could not make transaction");
			}
			else {
				res = true;
			}
		}
		return res;
	}
	public double getOutstandingBalance(String loan_account_number) {
		double outstanding_balance = 0;
		Connection con = dbConnection.connect();
		try {
			String sql = "select outstanding_balance from loan_balance where loan_account_number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				outstanding_balance = rs.getDouble("outstanding_balance");
			}
			if(outstanding_balance == 0) {
				throw new LoanApplicationException("Could not get balance");
			}
		}catch(SQLException e) {
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
		return outstanding_balance;
	}
	public boolean updateLoanBalance(String loan_account_number, double amount) {
		boolean updateFlag = false;
		Connection con = dbConnection.connect();
		try {
			String sql = "update loan_balance set principal_paid = principal_paid + ?, outstanding_balance = outstanding_balance - ?, current_principal = current_principal - ? where loan_account_number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setDouble(2, amount);
			pstmt.setDouble(3, amount);
			pstmt.setString(4, loan_account_number);
			int res = pstmt.executeUpdate();
			if(res == 0) {
				throw new LoanApplicationException("Could not make transaction ");
			}
			else {
				updateFlag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return updateFlag;
	}

	@Override
	public LoanBalance getLoanBalance(String loan_account_number) {
		Connection con=	dbConnection.connect();
		LoanBalance loanBalance = null;
		try {
			String sql="select * from loan_balance where loan_account_number = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, loan_account_number);
			ResultSet rs= pstmt.executeQuery();
			System.out.println("connected.. + executed");
			while( rs.next()) {
				
				loanBalance = new LoanBalance();
				loanBalance.setPrincipal_paid(rs.getDouble("principal_paid"));
				loanBalance.setInterest_paid(rs.getDouble("interest_paid"));
				loanBalance.setLoan_account_number(rs.getString("loan_account_number"));
				loanBalance.setCustomer_id(rs.getString("customer_id"));
				loanBalance.setOutstanding_balance(rs.getDouble("outstanding_balance"));
				loanBalance.setTenure_remaining(rs.getInt("tenure_remaining"));
				loanBalance.setInterest_rate(rs.getDouble("interest_rate"));
				loanBalance.setCurrent_principal(rs.getDouble("current_principal"));
				
			}
			if(loanBalance == null) {
				throw new LoanApplicationException("Could not find balance");
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
		return loanBalance;
	}
	public boolean updateLoanAccount(LoanBalance loanBalance) {
		boolean res = false;
		Connection con = dbConnection.connect();
		try {
			String sql = "update loan_account set emi = ? where loan_account_number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			double current_principal = loanBalance.getCurrent_principal();
			int tenure_remaining = loanBalance.getTenure_remaining();
			double interest_rate = loanBalance.getInterest_rate();
			interest_rate = interest_rate / 12;
			interest_rate = interest_rate / 100;
			double emi = (current_principal * interest_rate *((Math.pow(1 + interest_rate, tenure_remaining))/((Math.pow((1 + interest_rate), tenure_remaining) - 1))));
			System.out.println("new emi: " + emi);
			pstmt.setDouble(1, emi);
			pstmt.setString(2, loanBalance.getLoan_account_number());
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new LoanApplicationException("Could not make transaction");
			}
			else {
				res = true;
			}
		}
		catch(SQLException e) {
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
		return res;
	}
	private Map<String, LoanBalance> getLoanBalance(){
		Map<String, LoanBalance> map = new HashMap<>();
		Connection con = dbConnection.connect();
		try {
			String sql = "select * from loan_balance";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LoanBalance loanBalance = new LoanBalance();
				loanBalance.setPrincipal_paid(rs.getDouble("principal_paid"));
				loanBalance.setInterest_paid(rs.getDouble("interest_paid"));
				loanBalance.setLoan_account_number(rs.getString("loan_account_number"));
				loanBalance.setCustomer_id(rs.getString("customer_id"));
				loanBalance.setOutstanding_balance(rs.getDouble("outstanding_balance"));
				loanBalance.setTenure_remaining(rs.getInt("tenure_remaining"));
				loanBalance.setInterest_rate(rs.getDouble("interest_rate"));
				loanBalance.setCurrent_principal(rs.getDouble("current_principal"));
				map.put(rs.getString("loan_account_number"), loanBalance);
			}
			if(map.size() == 0) {
				throw new LoanApplicationException("could ");
			}
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
		return map;
	}
	private Map<String, Double> getEmi(){
		Map<String, Double> map = new HashMap<>();
		Connection con = dbConnection.connect();
		try {
			String sql = "select loan_account_number, emi from loan_account";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString("loan_account_number"), rs.getDouble("emi"));
			}
			if(map.size() == 0) {
				throw new LoanApplicationException("could ");
			}
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
		return map;
	}
	
	private boolean updateLoanBalanceEmi(LoanBalance loanBalance) {
		Connection con = dbConnection.connect();
		boolean updateFlag = false;
		try {
			
			String sql = "update loan_balance set principal_paid = principal_paid + ?, interest_paid = interest_paid + ?, outstanding_balance = ?, tenure_remaining = ?, current_principal = ? where loan_account_number = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, loanBalance.getPrincipal_paid());
			pstmt.setDouble(2, loanBalance.getInterest_paid());
			pstmt.setDouble(3, loanBalance.getOutstanding_balance());
			pstmt.setDouble(4, loanBalance.getTenure_remaining());
			pstmt.setDouble(5, loanBalance.getCurrent_principal());
			pstmt.setString(6, loanBalance.getLoan_account_number());
			int res = pstmt.executeUpdate();
			if(res == 0) {
				throw new LoanApplicationException("Could not Update EMI");
			}
			updateFlag = true;
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
		return updateFlag;
	}

	@Scheduled(cron = "0 0 12 25 * ?")
	private void payEmi() {
		Map<String, Double> mapEmi = getEmi();
		Map<String, LoanBalance> mapLoanBalance = getLoanBalance();
		for(Map.Entry<String, LoanBalance> records : mapLoanBalance.entrySet()) {
			LoanBalance bal = records.getValue();
			double interest_rate = bal.getInterest_rate();
			interest_rate = interest_rate / 12;
			interest_rate = interest_rate / 100;
			double emi = mapEmi.get(records.getKey());
			bal.setOutstanding_balance(emi * bal.getTenure_remaining());
			double interest_paid = bal.getCurrent_principal() * interest_rate;
			double principal_paid = emi - interest_paid;
			bal.setPrincipal_paid(bal.getPrincipal_paid() + emi);
			bal.setInterest_paid(interest_paid);
			bal.setPrincipal_paid(principal_paid);
			bal.setOutstanding_balance(bal.getOutstanding_balance() - emi);
			bal.setCurrent_principal(bal.getCurrent_principal() - principal_paid);
			bal.setTenure_remaining(bal.getTenure_remaining() - 1);
			System.out.println(updateLoanBalanceEmi(bal));
			System.out.println(insertTransaction( bal.getLoan_account_number(), emi, bal.getCustomer_id()));
		}
		
	}

	@Override
	public List<LoanBalance> getLoanBalanceCustomer(String customer_id) {
		Connection con=	dbConnection.connect();
		List<LoanBalance> resultList = new ArrayList<>();
		try {
			String sql="select * from loan_balance where customer_id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			ResultSet rs= pstmt.executeQuery();
//			System.out.println(customer_id);
			while( rs.next()) {
				
				LoanBalance loanBalance = new LoanBalance();
				loanBalance.setPrincipal_paid(rs.getDouble("principal_paid"));
				loanBalance.setInterest_paid(rs.getDouble("interest_paid"));
				loanBalance.setLoan_account_number(rs.getString("loan_account_number"));
				loanBalance.setCustomer_id(rs.getString("customer_id"));
				loanBalance.setOutstanding_balance(rs.getDouble("outstanding_balance"));
				loanBalance.setTenure_remaining(rs.getInt("tenure_remaining"));
				loanBalance.setInterest_rate(rs.getDouble("interest_rate"));
				loanBalance.setCurrent_principal(rs.getDouble("current_principal"));
				resultList.add(loanBalance);
				System.out.println("inside");
				
			}
			if(resultList.size() == 0) {
				throw new LoanApplicationException("Could not find balance");
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

}
