package org.example.bank2.entites;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@Document(collection = "accounts")

public class Account {

    @Id
    private String id;

    private String accountNumber; // Unique account number.

    private String type; // Account type (e.g., Savings, Checking).

    private boolean businessType; // True if this is a business account.

    private Double balance; // Current account balance.

    @Getter
    private String user; // Reference to the account owner.

    private Set<String> nominees; // References to nominee users.

    public Account(String id, String accountNumber, String type, boolean businessType, Double balance, String
            user , Set<String> nominees) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.businessType = businessType;
        this.balance = balance;
        this.user = user;
        this.nominees=nominees;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBusinessType() {
        return businessType;
    }

    public void setBusinessType(boolean businessType) {
        this.businessType = businessType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<String> getNominees() {
        return nominees;
    }

    public void setNominees(Set<String> nominees) {
        this.nominees = nominees;
    }
}
