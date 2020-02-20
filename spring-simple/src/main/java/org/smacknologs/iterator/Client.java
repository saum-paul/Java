package org.smacknologs.iterator;

import org.smacknologs.iterator.Menu.Iterator;

public class Client {

	Menu<String> menu;

	public Client(Menu<String> m) {
		menu = m;
	}

	public void listMenu() {
		Iterator<String> menuIterator = menu.createIterator();

		while (menuIterator.hasNext())
			System.out.println(menuIterator.next());
	}
}
