package org.smacknologs.datastructures;

public interface Array<E> {

	public boolean add(E e);

	public boolean remove(Object key);
	
	public E find(Object key);
	
	public boolean update(Object key,  E e);
	
	public int size();

}
