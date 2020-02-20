package org.smacknologs.iterator;

public class ArrayMenu implements Menu<String> {

	String[] menu;

	public ArrayMenu(String[] menu) {
		this.menu = menu;
	}

	@Override
	public Iterator<String> createIterator() {

		return new MyIterator();
	}

	private class MyIterator implements Iterator<String> {
		private int position = 0;

		@Override
		public boolean hasNext() {
			return (menu.length != position);
		}

		@Override
		public String next() {
			return menu[position++];
		}
	}
}
