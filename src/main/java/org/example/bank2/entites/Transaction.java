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

    private Double balanceAfterTransection;

    public Transaction(Double amount, UserInTransection sender,String currency, UserInTransection receiver, String type, String notes , Double balanceAfterTransection) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.notes = notes;
        this.balanceAfterTransection = balanceAfterTransection;
        this.type = type;
        this.currency = currency;
        this.createdAt = LocalDateTime.now();
    }

    public UserInTransection getSender() {
        return sender;
    }
    public UserInTransection getReceiver() {
        return receiver;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getCurrency() {
        return currency;
    }
    public String getType() {
        return type;
    }
    public String getNotes() {
        return notes;
    }
    public Double getBalanceAfterTransection() {
        return balanceAfterTransection;
    }

    public String getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }
}
