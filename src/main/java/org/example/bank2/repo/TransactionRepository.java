package org.example.bank2.repo;

import org.example.bank2.entites.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    @Query("{'createdAt': {$gte: ?0, $lte: ?1}}")
    List<Transaction> findTransactionsWithinTimeRange(LocalDateTime startTime, LocalDateTime endTime);
}
