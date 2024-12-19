package org.example.bank2.repo;

import org.example.bank2.entites.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
