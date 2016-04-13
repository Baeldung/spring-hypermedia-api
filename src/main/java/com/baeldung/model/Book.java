package com.baeldung.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    public Book() {
        super();
    }

    public Book(final String title) {
        super();

        this.title = title;
    }

    //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
