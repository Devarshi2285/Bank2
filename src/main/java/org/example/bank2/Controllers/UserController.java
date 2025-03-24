package org.example.bank2.Controllers;

import lombok.experimental.Accessors;
import org.example.bank2.DTO.NomineeRequest;
import org.example.bank2.entites.User;
import org.example.bank2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return (User) userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users= userService.getAllUsers();
       System.out.println(users);
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
