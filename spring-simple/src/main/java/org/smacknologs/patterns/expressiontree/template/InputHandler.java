package org.smacknologs.patterns.expressiontree.template;

public abstract class InputHandler {
	void handleInput() {
		
	}
	abstract void promptUser();
	abstract void receiveInput();
	abstract void execute();

}
