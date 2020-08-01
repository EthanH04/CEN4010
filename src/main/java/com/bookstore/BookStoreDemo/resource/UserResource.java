package com.bookstore.BookStoreDemo.resource;
/*
import com.bookstore.BookStoreDemo.model.CreditCard;
import com.bookstore.BookStoreDemo.model.User;
import com.bookstore.BookStoreDemo.repository.CreditCardRepository;
import com.bookstore.BookStoreDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geektext")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    //Displays User By Username Search
    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        Optional<User> users = userRepository.findById(username);
        if (users.isPresent()) {
            return users.get();
        } else{
                throw new RuntimeException("User '" + username + "' not found");
            }
        }

    //Displays List of All Users on Database
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Creates a New User
    @PostMapping("/users")
    public User loadUser(@RequestBody final User user) {
        user.setEmail(user.getUsername());
        return userRepository.save(user);
    }

    //Creates a List of New Users
    @PostMapping("/users/all")
    public List <User> loadAllUsers(@RequestBody final List <User> users) {
        return userRepository.saveAll(users);
    }

    //Updates an Existing User
    @PutMapping("/users/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        //make email te same as user
        //if fields are null, then get them before saving
        return userRepository.save(user);
    }

    //Deletes an Existing User
    @DeleteMapping("/users/{username}")
    public String deleteUser(@PathVariable String username) {
        Optional <User> user = userRepository.findById(username);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "User '" + username + "' has been deleted";
        } else {
            throw new RuntimeException("User '" + username + "' not found");
        }
    }

}
*/