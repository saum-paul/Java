package org.smacknologs.model;

import java.util.List;

public interface Bookshelf extends List<Book> {

	default void init() {
		add(new Book("BM", "Clean Code", 10.0));
		add(new Book("MF", "Refactoring", 12.0));
		add(new Book("MF", "PEAA", 20.0));
	}

	<E extends Book> boolean add(E book);

	Bookshelf getInstance();

	Book findByTitle(String title);
}
