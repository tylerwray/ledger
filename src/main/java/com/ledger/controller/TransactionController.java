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

import javax.validation.Valid;
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
    TransactionDto get(@PathVariable UUID uid) {
        System.out.println("Tyler -> " + uid);
        return mapper.transactionToTransactionDto(transactionService.findByUid(uid));
    }
}
