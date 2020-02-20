package org.smacknologs.patterns.factory.apps;

public abstract class Apps {
	void show() {
		System.out.println("Opening App: " + this.getClass().getSimpleName());
	}
	
	abstract void execute();
}
