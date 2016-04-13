package com.baeldung.web.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.resource.BookResource;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	//

	@RequestMapping("/{id}")
	public BookResource findOne(@PathVariable("id") long id) {
		final Book book = bookRepository.findOne(id);
		if (book == null) {
			throw new EntityNotFoundException("No book found for id = " + id);
		}

		return new BookResource(book);
	}

}
