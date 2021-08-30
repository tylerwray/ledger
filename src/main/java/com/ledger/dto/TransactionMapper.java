package com.ledger.dto;

import com.ledger.domain.Transaction;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    TransactionDto transactionToTransactionDto(Transaction transaction);

    Transaction transactionDtoToTransaction(TransactionDto transactionDto);

    default Timestamp map(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}