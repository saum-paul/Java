package org.smacknologs.filter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.smacknologs.model.Book;
import org.smacknologs.model.Bookshelf;
import org.smacknologs.model.BookshelfImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bookshelf bookshelf = new BookshelfImpl().getInstance();

		Criteria equalTo12 = new PriceCriteria(12.0);
		// equalTo12.match(bookshelf).stream().forEach(s -> System.out.println(s));

		Criteria mfAuthor = new AuthorCriteria("MF");
		// mfAuthor.match(bookshelf).stream().forEach(s -> System.out.println(s));

		Criteria or = new OrCriteria(mfAuthor, equalTo12);
//		or.match(bookshelf).stream().forEach(s -> System.out.println(s));

		AndCriteria and = new AndCriteria(mfAuthor, equalTo12);
//		and.match(bookshelf).stream().forEach(s -> System.out.println(s));

		List<Predicate<Book>> predicates = Arrays.asList(b -> b.getAuthor() == "MF",
				b -> new BigDecimal(20.0).equals(new BigDecimal(b.getPrice())));

		Predicate<Book> composite = predicates.stream().reduce(w -> true, Predicate::and);
		bookshelf.stream().filter(composite).forEach(s -> System.out.println(s));

	}
}
