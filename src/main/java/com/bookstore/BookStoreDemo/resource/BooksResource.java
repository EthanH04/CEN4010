package com.bookstore.BookStoreDemo.resource;

import com.bookstore.BookStoreDemo.model.Books;
import com.bookstore.BookStoreDemo.repository.BooksRepository;
//import com.bookstore.BookStoreDemo.repository.CustomBooksRepository;
import exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greektext/books")
public class BooksResource {

    @Autowired
    BooksRepository booksrepo;
    //CustomBooksRepository custombooksrepo;

    @GetMapping("/all")
    public List<Books> getAll() {
        return booksrepo.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public Books getById(@PathVariable Long isbn) {
        return booksrepo.findById(isbn).orElseThrow(() -> new NotFoundException("Book with ISBN " + isbn + " is not found!"));
    }

    @GetMapping(value = "/author/{author}")
    public List<Books> getByAuthor(@PathVariable String author) {
        return booksrepo.findByAuthor(author);
    }

    @GetMapping(value = "/genre/{genre}")
    public List<Books> getByGenre(@PathVariable String genre) {
        return booksrepo.findByGenre(genre);
    }


    @GetMapping(value = "/sold")
    public List<Books> getTop() { return booksrepo.findTop10ByOrderBySoldDesc();
    }

    @GetMapping(value = "/browse/{limit}")
    public List<Books> getCertain(@PathVariable Integer limit) {return booksrepo.findOrderedByPriceLimitedTo(limit);
    }


    @PostMapping(value = "/create")
    public List<Books> persist(@RequestBody final Books book) {
        booksrepo.save(book);
        return booksrepo.findAll();
    }
    
    @PutMapping(value = "/update")
    public String update(@RequestBody final Books book) {
        booksrepo.save(book);
        return "Book with ISBN " + book.getIsbn() + " is updated!";
    }
    
    @DeleteMapping(value = "/delete/{isbn}")
    public String delete(@PathVariable Long isbn) {
        Optional<Books> book = booksrepo.findById(isbn);
        if(book.isPresent()) {
            booksrepo.delete(book.get());
            return "Book with ISBN " + isbn + " is deleted!";
        }
        else {
            throw new NotFoundException("Book with ISBN " + isbn + " does not exist!");
        }
    }
}
