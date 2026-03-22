package com.daniel.financeapi;
import org.springframework.data.jpa.repository.JpaRepository;
public class TransactionRepository {
    public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    }
}
