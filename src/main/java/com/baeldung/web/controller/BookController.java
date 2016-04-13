package com.baeldung.web.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.resource.BookResource;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository repo;

    //

    @RequestMapping("/{id}")
    public BookResource findOne(@PathVariable("id") long id) {
        final Book book = repo.findOne(id);
        if (book == null) {
            throw new EntityNotFoundException("No book found for id = " + id);
        }

        return new BookResource(book);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody BookResource newBook) {
        repo.save(newBook.getContent());
    }

}
