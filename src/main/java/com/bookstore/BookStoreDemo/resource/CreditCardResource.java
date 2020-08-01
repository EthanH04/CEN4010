package com.bookstore.BookStoreDemo.resource;
/*
import com.bookstore.BookStoreDemo.model.CreditCard;
import com.bookstore.BookStoreDemo.model.User;
import com.bookstore.BookStoreDemo.repository.CreditCardRepository;
import com.bookstore.BookStoreDemo.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geektext")
class CreditCardResource {

    @Autowired
    CreditCardRepository cardsRepository;

    @Autowired
    UserRepository userRepository;

    //Displays List of All Credit Cards on Database
    @GetMapping("/cards")
    public List <CreditCard> getAllCreditCards() {
        return cardsRepository.findAll();
    }

    //Displays CreditCard By Username Search
    @GetMapping("/users/{username}/cards")
    public List<CreditCard> getCardsByUsername(@PathVariable String username) throws NotFoundException {
        if (userRepository.findById(username).isEmpty()){
            throw new NotFoundException("User '" + username + "' not found");
        }
        return cardsRepository.findByUser(userRepository.findById(username).get());
    }

    //Creates New Card for User
    @PostMapping("/users/{username}/cards")
    public CreditCard loadCard(@PathVariable String username, @RequestBody CreditCard creditCard) throws NotFoundException {

        if (userRepository.findById(username).isEmpty()) {
            throw new NotFoundException("User '" + username + "' not found");
        }
        if (!cardsRepository.findById(creditCard.getCardNumber()).isEmpty()) {
            throw new NotFoundException("Credit Card '" + creditCard.getCardNumber() + "' already on File");
        }
            User user = userRepository.findById(username).get();
            user.getCreditCard().add(creditCard);
            creditCard.setUser(userRepository.findById(username).get());
            userRepository.save(user);
            return cardsRepository.save(creditCard);
    }

    //Deletes an Existing Card By cardNumber
    @DeleteMapping("/users/{username}/cards/{cardNumber}")
    public String deleteCard(@PathVariable String username, @PathVariable BigInteger cardNumber) throws NotFoundException {

        if (userRepository.findById(username).isEmpty()) {

            throw new NotFoundException("User '" + username + "' not found");

        } else if (cardsRepository.findById(cardNumber).isEmpty()) {

            throw new NotFoundException("Credit Card not found");
        }

        cardsRepository.delete(cardsRepository.findById(cardNumber).get());
        return "Credit Card '" + cardNumber + "' has been deleted";

        }

        //Delete all credit cards by username************
}*/