package org.acme.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> all(){
        return bookRepository.findAll();
    }

    @GetMapping("/{lower}/{higher}")
    public List<Book> findByDate(@PathVariable Integer lower, @PathVariable Integer higher){
        return bookRepository.findByPublicationYearIsBetween(lower,higher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new MissingBookException();
        }
    }
}
