package com.bookstore.BookStoreDemo.resource;

import com.bookstore.BookStoreDemo.model.Authors;
import com.bookstore.BookStoreDemo.repository.AuthorsRepository;
import exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greektext/authors")
public class AuthorsResource {
    
    @Autowired
    AuthorsRepository authorsrepo;
    
    @GetMapping(value = "/all")
    public List<Authors> getAll() {
        return authorsrepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Authors getById(@PathVariable int id) {
        return authorsrepo.findById(id).orElseThrow(() -> new NotFoundException("Author with id " + id + " is not found!"));
    }
    
    @PostMapping(value = "/create")
    public List<Authors> persist(@RequestBody final Authors author) {
        authorsrepo.save(author);
        return authorsrepo.findAll();
    }
    
    @PutMapping(value = "/update")
    public String update(@RequestBody final Authors author) {
        authorsrepo.save(author);
        return "Author is updated!";
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Authors> author = authorsrepo.findById(id);
        if(author.isPresent()) {
            authorsrepo.delete(author.get());
            return "Author with id " + id + " is deleted!";
        }
        else {
            throw new NotFoundException("Author with id " + id + " does not exist!");
        }
    }
}
