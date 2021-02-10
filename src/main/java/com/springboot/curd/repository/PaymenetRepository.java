package com.springboot.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.curd.entities.Payment;

public interface PaymenetRepository extends JpaRepository<Payment, Integer> {

}
