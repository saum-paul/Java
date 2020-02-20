package org.smacknologs.coffeeshop;

public class Whip extends Beverage {

	public Whip(Beverage b) {
		super(b);
	}

	@Override
	public String getDescription() {
		return b.getDescription() + "Single Whipped Cream";
	}

	@Override
	public double cost() {
		return b.cost() + 1.0;
	}

}
