package org.example.bank2.services;

import lombok.RequiredArgsConstructor;
import org.example.bank2.entites.User;
import org.example.bank2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users= userRepository.findAll();
        System.out.println(users);
        return users;
    }

    public User createUser(User user) {
        System.out.println("Here..."+user);
        return (User) userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User saveUser(User user) {
        return userRepository.save(user); // Save or update the user
    }



}
