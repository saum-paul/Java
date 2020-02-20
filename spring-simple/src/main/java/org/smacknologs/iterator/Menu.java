package org.smacknologs.iterator;

public interface Menu<E> {
	public Iterator<E> createIterator();

	public interface Iterator<E> {

		boolean hasNext();

		E next();

	}
}
