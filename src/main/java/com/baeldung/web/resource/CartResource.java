package com.baeldung.web.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.baeldung.model.Book;
import com.baeldung.web.controller.CartController;

public class CartResource extends ResourceSupport {

    private final List<Book> books;

    private boolean purchased;

    public CartResource() {
        super();

        this.books = new ArrayList<Book>();
        this.add(linkTo(methodOn(CartController.class).seeYourCart()).withSelfRel());
    }

    //

    public List<Book> getBooks() {
        return books;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    //

    public final void add(final Book bookToAdd) {
        books.add(bookToAdd);
    }

}
