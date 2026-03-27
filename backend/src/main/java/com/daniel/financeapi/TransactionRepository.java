package com.daniel.financeapi;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.financeapi.model.Transaction;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
