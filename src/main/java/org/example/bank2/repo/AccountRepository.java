package org.example.bank2.repo;

import org.example.bank2.entites.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUser(String userId);
}
