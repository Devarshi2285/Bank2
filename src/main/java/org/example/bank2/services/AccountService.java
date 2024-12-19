package org.example.bank2.services;

import lombok.RequiredArgsConstructor;
import org.example.bank2.entites.Account;
import org.example.bank2.repo.AccountRepository;
import org.example.bank2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
    public Account getAccountBySenderId(String senderId) {
        Optional<Account> account = accountRepository.findByUser(senderId);

        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RuntimeException("Account not found for senderId: " + senderId);
        }
    }

    public Account updateAccount(String accountId, Account updatedAccount) {
        return accountRepository.findById(accountId).map(existingAccount -> {
            // Update fields
            existingAccount.setBalance(updatedAccount.getBalance());
            existingAccount.setNominees(updatedAccount.getNominees());

            // Save the updated account
            return accountRepository.save(existingAccount);
        }).orElseThrow(() -> new RuntimeException("Account not found with ID: " + accountId));
    }

}
