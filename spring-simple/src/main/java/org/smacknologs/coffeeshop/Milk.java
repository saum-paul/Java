package org.smacknologs.coffeeshop;

public class Milk extends Beverage {

	public Milk() {
		super(null);
	}
	
	public Milk(Beverage b) {
		super(b);
	}

	@Override
	public String getDescription() {
		
		return b.getDescription() + "1 cup Milk";
	}

	@Override
	public double cost() {
		return b.cost() + 0.5;
	}

}
