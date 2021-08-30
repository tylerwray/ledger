package com.ledger.service;

import com.ledger.domain.Transaction;

import java.util.UUID;

public interface TransactionService {
    Transaction insert(Transaction transaction);
    Transaction findByUid(UUID uid);
}