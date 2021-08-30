package com.ledger.service;

import com.ledger.domain.Transaction;
import com.ledger.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction insert(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction findByUid(UUID uid) {
        return transactionRepository.findByUid(uid);
    }
}