package org.smacknologs.filter;

import java.util.List;

import org.smacknologs.model.Book;

public class AndCriteria implements Criteria {
	Criteria first;
	Criteria second;

	public AndCriteria(Criteria first, Criteria second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public List<Book> match(List<Book> bookshelf) {

		return first.match(second.match(bookshelf));
	}

}
