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
@Getter
@Setter
public class Transaction {

    @Id
    private String id;

    private Double amount; // Transaction amount.

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // Ensures consistent formatting
    private LocalDateTime createdAt;

    private UserInTransection sender; // Sender of the transaction.

    private String currency;
    @Getter
    private UserInTransection receiver; // Receiver of the transaction.

    private String type;

    private String notes;

    private Double balanceAfterTransaction;

    public Transaction(Double amount, UserInTransection sender,String currency, UserInTransection receiver, String type, String notes , Double balanceAfterTransaction) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.notes = notes;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.type = type;
        this.currency = currency;
        this.createdAt = LocalDateTime.now();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserInTransection getSender() {
        return sender;
    }

    public void setSender(UserInTransection sender) {
        this.sender = sender;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public UserInTransection getReceiver() {
        return receiver;
    }

    public void setReceiver(UserInTransection receiver) {
        this.receiver = receiver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getBalanceAfterTransection() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransection(Double balanceAfterTransection) {
        this.balanceAfterTransaction = balanceAfterTransection;
    }
}
