package org.smacknologs.cache;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 7788327611744203507L;
	private int size;

	public LRUCache(int size) {
		super(size, 1.0f, true);
		this.size = size;
	}

	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<K, V> eldest) {
		return size() > this.size;
	}

}
