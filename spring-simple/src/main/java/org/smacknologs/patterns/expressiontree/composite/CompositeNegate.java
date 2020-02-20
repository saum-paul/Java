package org.smacknologs.patterns.expressiontree.composite;

public class CompositeNegate extends CompositeUnary {

	public CompositeNegate(BaseComponent right) {
		super(right);
	}

	@Override
	public int item() {
		return '-';
	}
}
