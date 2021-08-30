package com.ledger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class TransactionDto {
    @Positive(message = "Field `amount` must be greater than 0")
    @NotNull(message = "Field `amount` cannot be blank")
    private Integer amount;

    @NotNull(message = "Field `destination_id` cannot be blank")
    @JsonProperty("destination_id")
    private String destinationId;

    @NotNull(message = "Field `destination_id` cannot be blank")
    @JsonProperty("source_id")
    private String sourceId;

    private String timestamp;
    private UUID uid;

    public String object = "transaction";

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }
}