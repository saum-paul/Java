package org.smacknologs.filter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.smacknologs.model.Book;

public class PriceCriteria implements Criteria {
	private BigDecimal price;

	public PriceCriteria(Double price) {
		this.price = new BigDecimal(price);
	}

	@Override
	public List<Book> match(List<Book> bookshelf) {
		return bookshelf.stream()
				.filter(b -> new BigDecimal(b.getPrice()).equals(this.price))
				.collect(Collectors.toList());
	}

}
