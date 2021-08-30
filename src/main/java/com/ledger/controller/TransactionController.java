package com.ledger.controller;

import com.ledger.domain.Transaction;
import com.ledger.dto.TransactionDto;
import com.ledger.dto.TransactionMapper;
import com.ledger.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Validated
public class TransactionController {
    private final TransactionMapper mapper;
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(
            TransactionMapper mapper,
            TransactionService transactionService
    ) {
        this.mapper = mapper;
        this.transactionService = transactionService;
    }

    @PostMapping("/api/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    TransactionDto post(@Valid @RequestBody TransactionDto transactionDto) {
        Transaction transaction = transactionService.insert(
                mapper.transactionDtoToTransaction(transactionDto)
        );

        return mapper.transactionToTransactionDto(transaction);
    }

    @GetMapping("/api/transactions/{uid}")
    ResponseEntity<Object> get(@PathVariable UUID uid) {
        Transaction transaction = transactionService.findByUid(uid);
        if (transaction == null) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", new Date());

            body.put("error", String.format("Transaction with uid %s not found.", uid));

            return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mapper.transactionToTransactionDto(transaction), HttpStatus.OK);
    }
}
