package org.example.bank2.Controllers;

import org.example.bank2.entites.Account;
import org.example.bank2.entites.Transaction;
import org.example.bank2.entites.User;
import org.example.bank2.services.AccountService;
import org.example.bank2.services.TransactionService;
import org.example.bank2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public TransactionController(TransactionService transactionService,UserService userService , AccountService accountService) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.accountService = accountService;
    }

    // Endpoint to create a new transaction
    @PostMapping("/debit")
    public ResponseEntity<String> createTransactionForDebit(@RequestBody Transaction transaction) {
        try {
            // Retrieve the sender and receiver's user entities



            Account senderAccount = accountService.getAccountById((String) transaction.getSender());
            // Ensure the sender has enough balance for the transaction
            if (senderAccount.getBalance() < transaction.getAmount()) {
                return ResponseEntity.badRequest().body("Insufficient funds");
            }

            // Subtract the amount from sender's balance
            senderAccount.setBalance(senderAccount.getBalance() - transaction.getAmount());
            accountService.updateAccount(senderAccount.getId(),senderAccount); // Save the updated sender's balance


            // Create the transaction record
            transactionService.createTransaction(transaction);

            return ResponseEntity.ok("Transaction completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Transaction failed: " + e.getMessage());
        }
    }

    @PostMapping("/credit")
    public ResponseEntity<String> createTransactionForCredit(@RequestBody Transaction transaction) {
        try {
            // Retrieve the sender and receiver's user entities



            Account receiverAccount = accountService.getAccountById(transaction.getReceiver());
            // Ensure the sender has enough balance for the transaction


            // Subtract the amount from sender's balance
            receiverAccount.setBalance(receiverAccount.getBalance() + transaction.getAmount());
            accountService.updateAccount(receiverAccount.getId(),receiverAccount); // Save the updated sender's balance


            // Create the transaction record
            transactionService.createTransaction(transaction);

            return ResponseEntity.ok("Transaction completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Transaction failed: " + e.getMessage());
        }
    }


    // Endpoint to get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions= transactionService.getAllTransactions();



        return transactions;
    }


    // Endpoint to get a transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }
}
