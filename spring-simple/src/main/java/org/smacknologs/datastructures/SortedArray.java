package org.smacknologs.datastructures;

class SortedArray<T extends Comparable<T>> implements Array<T> {

	private int index;
	private int capacity;
	private Comparable<T>[] data;
	private static final int DEFAULT_SIZE = 10;

	@SuppressWarnings("unchecked")
	public SortedArray(int capacity) {
		data = new Comparable[capacity];
		this.capacity = capacity;
		this.index = 0;
	}

	public SortedArray() {
		this(DEFAULT_SIZE);
	}	

	@SuppressWarnings("unchecked")
	private void upsize() {
		this.capacity = this.capacity * 2;
		Comparable<T>[] temp = data;
		data = new Comparable[capacity];
		System.arraycopy(temp, 0, data, 0, temp.length);
	}


	@Override
	public int size() {
		return index;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object key, T e) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
