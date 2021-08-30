package com.ledger.repository;

import com.ledger.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("SELECT t FROM transactions t WHERE t.uid = ?1")
    Transaction findByUid(UUID uid);
}