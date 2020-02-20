package org.smacknologs.filter;

import java.util.List;

import org.smacknologs.model.Book;

public interface Criteria {
	public List<Book> match(List<Book> bookshelf);

}
