package org.smacknologs.datastructures;

class UnsortedArray<E> implements Array<E> {

	private int index;
	private int capacity;
	private E[] data;
	private static final int DEFAULT_SIZE = 10;

	@SuppressWarnings("unchecked")
	public UnsortedArray(int capacity) {
		data = (E[]) new Object[capacity];
		this.capacity = capacity;
		this.index = 0;
	}

	public UnsortedArray() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	private void upsize() {
		this.capacity = this.capacity * 2;
		E[] temp = data;
		data = (E[]) new Object[capacity];
		System.arraycopy(temp, 0, data, 0, temp.length);
	}

	@Override
	public boolean add(E e) {
		try {
			if (index == capacity)
				upsize();

			data[index++] = e;
		} catch (RuntimeException ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Object key) {
		int i = 0;

		while (i < index && !data[i].equals(key))
			i++;
		if (i == index)
			return false;
		
		while (i < index) {
			data[i] = data[++i];
		}
		index--;
		
		return true;
	}

	@Override
	public E find(Object key) {
		int i = 0;

		while (i < index && !data[i].equals(key))
			i++;
		if (i == index)
			return null;

		return data[i];
	}

	@Override
	public boolean update(Object key, E e) {
		return remove(key) && add(e);
	}
	
	@Override
	public int size() {
		return index;
	}

}
