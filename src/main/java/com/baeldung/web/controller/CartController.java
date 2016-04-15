package com.baeldung.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.error.Checks;
import com.baeldung.web.resource.BookResource;
import com.baeldung.web.resource.CartResource;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private CartResource cart;

    @Autowired
    private BookRepository bookRepo;

    // read

    @RequestMapping(method = RequestMethod.POST)
    public CartResource addBookToCart(@RequestBody final BookResource book) {
        final String isbn = book.getContent().getIsbn();
        final Book bookToAdd = Checks.checkEntityExists(bookRepo.findByIsbn(book.getContent().getIsbn()), "No Book found for isbn: " + isbn);

        initializeCart().add(bookToAdd);
        return cart;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public CartResource buy(@RequestBody final CartResource theCart) {
        initializeCart();

        if (theCart.isPurchased()) {
            this.cart.setPurchased(true);
        }

        return this.cart;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CartResource seeYourCart() {
        return initializeCart();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void clearYourCart() {
        initializeCart().getBooks().clear();
    }

    //

    public CartResource initializeCart() {
        if (cart == null) {
            this.cart = new CartResource();
        }

        return this.cart;
    }

}
