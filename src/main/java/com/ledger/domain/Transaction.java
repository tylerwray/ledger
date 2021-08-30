package com.ledger.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "transactions")
@Table(
        name = "transactions",
        indexes = {
                @Index(name = "transactions_source_id_index", columnList = "source_id"),
                @Index(name = "transactions_destination_id_index", columnList = "destination_id"),
                @Index(name = "transactions_uid_index", columnList = "uid")
        })
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int amount;

    @Column(name = "destination_id", nullable = false)
    private String destinationId;

    @Column(name = "source_id", nullable = false)
    private String sourceId;

    @Column(name = "timestamp", nullable = false)
    private java.sql.Timestamp timestamp;

    @Column(name = "uid", nullable = false)
    private UUID uid = UUID.randomUUID();

    public int getAmount() {
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

    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getUid() {
        return uid;
    }
}
