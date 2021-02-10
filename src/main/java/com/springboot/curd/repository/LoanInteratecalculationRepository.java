package com.springboot.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.curd.entities.Account;

public interface LoanInteratecalculationRepository extends JpaRepository<Account, Integer>{
	
	//public Account save(Account account);

}
