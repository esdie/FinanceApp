package com.oracle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entity.LoanApplication;
import com.oracle.entity.Loans;
import com.oracle.service.LoanService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@GetMapping("/test")
	public String testApi() {
		System.out.println("Hii");
		return "test successful";
	}
	
	@GetMapping("/loantypes")
	public List<Loans> getLoanType(){
		return loanService.getLoansService();
	}
	
	@GetMapping("/loanApplication/all")
	public List<LoanApplication> getAllApplications(){
		return loanService.getAllLoanApplicationService();
	}
	
	@GetMapping("/loanApplication/date/{start_date}/{end_date}")
	public List<LoanApplication> searchApplicationByDate(@PathVariable String start_date, @PathVariable String end_date){
		return loanService.searchLoanApplicationByDateService(start_date,end_date);
	}
	
	@GetMapping("/loanApplication/number/{loan_application_number}")
	public LoanApplication searchApplicationByNumber(@PathVariable String loan_application_number){
		return loanService.searchLoanApplicationByNumberService(loan_application_number);
	}
	
	@GetMapping("/loanApplication/type/{type_code}")
	public List<LoanApplication> searchApplicationByType(@PathVariable int type_code){
		return loanService.searchLoanApplicationByTypeService(type_code);
	}
	
	@GetMapping("/loanApplication/customer/{customer_id}")
	public List<LoanApplication> searchApplicationByCustomer(@PathVariable String customer_id){
		return loanService.searchLoanApplicationByCustomerService(customer_id);
	}
	@GetMapping("/loanApplication/status/{loan_status}")
	public List<LoanApplication> searchApplicationByStatus(@PathVariable String loan_status){
		return loanService.searchLoanApplicationByStatusService(loan_status);
	}

	@PostMapping("/loanApplication/apply")
	public LoanApplication applyLoan(@RequestBody LoanApplication a){
		return loanService.applyLoan(a);
	}
	@DeleteMapping("/loanApplication/cancel/{loan_application_number}")
	public List<LoanApplication> cancelLoan(@PathVariable String loan_application_number) {
		return loanService.cancelLoanApplicationService(loan_application_number);
	}
	@PutMapping("/loanApplication/reject/{loan_application_number}")
	public List<LoanApplication> rejectLoan(@PathVariable String loan_application_number ){
		return loanService.rejectLoanApplicationService(loan_application_number);
	}
	@PutMapping("/loanApplication/approve/{loan_application_number}/{amount}/{tenure}")
	public List<LoanApplication> approveLoan(@PathVariable String loan_application_number, @PathVariable double amount, @PathVariable int tenure ){
		return loanService.approveLoanApplicationService(loan_application_number, amount, tenure);
	}
}
