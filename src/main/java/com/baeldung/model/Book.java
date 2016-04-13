package com.baeldung.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private long id;

	@Column(nullable = false)
	private String name;

	public Book() {
		super();
	}

	public Book(final String name) {
		super();

		this.name = name;
	}

	//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
