package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.calc.TaxOperations;
import com.account.model.Account;
import com.account.repo.AccountRepo;


@RestController
@CrossOrigin("*")
public class AccountController {

	
	@Autowired
	private AccountRepo ar;
	
	@GetMapping("/accounts")
	@CrossOrigin("*")
	public List<Account> getAcc(){
		return ar.findAll();
	}
	@PostMapping("/saveAccount")
	@CrossOrigin("*")
	public List<Account> saveAcc(@RequestBody Account acc) {
		TaxOperations to=(bal)->{
			if (bal <= 50000) {
				bal *= 0.01;
	        } else if (bal <= 75000) {
	        	bal *= 0.02;
	        } else if (bal <= 100000) {
	        	bal *= 0.03;
	        } else if (bal <= 250000) {
	        	bal *= 0.04;
	        } else if (bal <= 500000) {
	        	bal *= 0.05;
	        } else
	        	bal *= 0.06;
			return bal;
		};
		acc.setTax(to.calculateTax(acc.getBalance()));
		ar.save(acc);
		return ar.findAll();
	}
	@GetMapping("/account/{accNo}")
	@CrossOrigin("*")
	public Account getAccount(@PathVariable("accNo") int accNo) {
		return ar.findByAccNo(accNo);
	}
	@DeleteMapping("/delete/{accNo}")
	public List<Account> deleteAccount(@PathVariable("accNo") int accNo) {
		Account a=ar.findByAccNo(accNo);
		ar.delete(a);
		return ar.findAll();
	}
}
