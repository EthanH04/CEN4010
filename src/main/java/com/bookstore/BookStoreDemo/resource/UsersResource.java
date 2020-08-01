package com.bookstore.BookStoreDemo.resource;

import com.bookstore.BookStoreDemo.model.Users;
import com.bookstore.BookStoreDemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/geektext")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    //Displays List of All Users
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    //Creates a New User
    @PostMapping("/users")
    public Users loadUser(@RequestBody final Users users) {
        users.setEmail(users.getUsername());
        return usersRepository.save(users);
    }

    //Updates an Existing User
    @PutMapping("/users")
    public Users updateUser(@RequestBody Users users) {
        return usersRepository.save(users);
    }

    //Deletes an Existing User
    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username) {
        Optional<Users> users = usersRepository.findById(username);
        if (users.isPresent()) {
            usersRepository.delete(users.get());
            return "User '" + username + "' has been deleted";
        } else {
            throw new RuntimeException("User '" + username + "' not found");
        }
    }
}