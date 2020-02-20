package org.smacknologs.coffeeshop;

public class Expresso extends Beverage {

	private static final String DESCRIPTION = "1 Cup Expresso";

	public Expresso() {
		super(null);
		this.description = DESCRIPTION;
	}

	public Expresso(Beverage b) {
		super(b);
		this.description = DESCRIPTION;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double cost() {
		if (null != b)
			return b.cost() + 1.0;
		else
			return 1.0;
	}

}
