package com.baeldung.web.resource;

import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.constraints.NotNull;

import com.baeldung.model.Book;
import com.baeldung.web.controller.BookController;

public class BookResource extends ResourceSupport {

    private final Book book;

    public BookResource(@NotNull final Book book) {
        this.book = book;

        this.add(linkTo(methodOn(BookController.class, book).findOne(book.getId())).withSelfRel());
    }

    //

    public Book getBook() {
        return book;
    }

}
