package org.example.bank2.entites;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    private Double amount; // Transaction amount.

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // Ensures consistent formatting
    private LocalDateTime createdAt;

    private Object sender; // Sender of the transaction.

    private String receiver; // Receiver of the transaction.

    private String receiverBankId; // Bank ID of the receiver.

    private String notes; // Notes for the transaction.

    public Transaction(Double amount, String sender, String receiver, String receiverBankId, String notes) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.notes = notes;
        this.receiverBankId = receiverBankId;
        this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    // Getters
    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Object getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getReceiverBankId() {
        return receiverBankId;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setSender(Object sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setReceiverBankId(String receiverBankId) {
        this.receiverBankId = receiverBankId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
