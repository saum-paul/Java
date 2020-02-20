package org.smacknologs.filter;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smacknologs.model.Book;

class AuthorCriteriaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMatch() {
		AuthorCriteria ac = new AuthorCriteria("MF");
		List<Book> matcher = Arrays.asList(new Book("MF", "Refactoring", 12.0), new Book("MF", "PEAA", 20.0));
	}

	
}