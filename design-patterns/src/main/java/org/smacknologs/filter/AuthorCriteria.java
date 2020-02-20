package org.smacknologs.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.smacknologs.model.Book;

public class AuthorCriteria implements Criteria {
	private String author;

	public AuthorCriteria(String author) {
		this.author = author;
	}

	@Override
	public List<Book> match(List<Book> bookshelf) {
		return bookshelf.stream()
				.filter(b -> b.getAuthor() == this.author)
				.collect(Collectors.toList());
	}

}
