package org.smacknologs.filter;

import java.util.List;

import org.smacknologs.model.Book;

public class OrCriteria implements Criteria {
	Criteria first;
	Criteria second;

	public OrCriteria(Criteria first, Criteria second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public List<Book> match(List<Book> bookshelf) {

		List orList = first.match(bookshelf);
		orList.addAll(second.match(bookshelf));
		return orList;
	}

}
