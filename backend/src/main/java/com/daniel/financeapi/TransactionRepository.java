package com.daniel.financeapi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.daniel.financeapi.model.User;


import com.daniel.financeapi.model.Transaction;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
