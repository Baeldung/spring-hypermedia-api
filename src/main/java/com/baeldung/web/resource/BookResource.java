package com.baeldung.web.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.Resource;

import com.baeldung.model.Book;
import com.baeldung.web.controller.BookController;

public class BookResource extends Resource<Book> {

    public BookResource(@NotNull final Book book) {
        super(book);

        this.add(linkTo(methodOn(BookController.class, book).findByIsbn(book.getIsbn())).withSelfRel());
        // this.add(linkTo(BookController.class).slash(book.getIsbn()).withSelfRel());
    }

    //

}
