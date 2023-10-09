package com.oracle.financeapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.oracle.service.LoanService;

@SpringBootTest
class FinanceAppApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	LoanService loanService;
	
	
}
