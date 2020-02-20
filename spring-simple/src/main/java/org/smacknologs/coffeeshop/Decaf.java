package org.smacknologs.coffeeshop;

public class Decaf extends Beverage {
	
	public Decaf() {
		super(null);
	}

	public Decaf(Beverage b) {
		super(b);
	}

	@Override
	public String getDescription() {
		return "1 Cup of Decaf";
	}

	@Override
	public double cost() {
		return 1.2;
	}

}
