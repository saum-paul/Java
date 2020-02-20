package org.smacknologs.coffeeshop;

public abstract class Beverage {

	String description;

	Beverage b;

	public Beverage(Beverage b) {
		this.b = b;
	}

	public abstract String getDescription();

	public abstract double cost();

}
