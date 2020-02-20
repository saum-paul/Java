package org.smacknologs.iterator;

import java.util.List;

public class ListMenu<E> implements Menu<E> {

	List<String> menu;

	public ListMenu(List<String> menu) {
		this.menu = menu;
	}

	@Override
	public Iterator<E> createIterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public E next() {
			return null;
		}
	}
}
