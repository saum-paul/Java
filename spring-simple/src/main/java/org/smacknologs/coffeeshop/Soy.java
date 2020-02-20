package org.smacknologs.coffeeshop;

public class Soy extends Beverage {

	public Soy() {
		super(null);
	}
	
	public Soy(Beverage b) {
		super(b);
	}

	@Override
	public String getDescription() {
		return "1 Cup Soy Milk";
	}

	@Override
	public double cost() {
		return b.cost() + 0.65;
	}

}
