package com.baeldung.web.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceSupport;

import com.baeldung.web.controller.BookController;

public class RootResource extends ResourceSupport {

    public RootResource() {
        this.add(linkTo(BookController.class).withRel("books"));
    }

    //

}
