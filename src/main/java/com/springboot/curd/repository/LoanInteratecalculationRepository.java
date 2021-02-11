package com.springboot.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.curd.entities.Account;

@Repository
public interface LoanInteratecalculationRepository extends JpaRepository<Account, Integer>{
	
	//public Account save(Account account);

}
