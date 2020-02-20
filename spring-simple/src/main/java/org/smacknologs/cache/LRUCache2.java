package org.smacknologs.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2<K, V> {

	private static final long serialVersionUID = 7788327611744203507L;
	private int size;
	private Map<Integer, Node<V>> map = new HashMap<>(size);
	private Node<V> head = new Node<>(null, null);

	public LRUCache2(int size) {
		this.size = size;
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			System.out.println("Key Exists");
			return;
		}

		Node<V> newNode = new Node(value, head.next);
		head.next = newNode;
		map.put(key, newNode);
	}
	
	static class Node<V> {
		private Node<V> next;
		private Node<V> prev;
		private V value;

		Node(V value, Node<V> next) {
			this.value = value;
			this.next = next;
		}
	}
}
