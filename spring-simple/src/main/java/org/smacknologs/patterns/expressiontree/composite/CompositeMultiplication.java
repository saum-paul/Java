package org.smacknologs.patterns.expressiontree.composite;

public class CompositeMultiplication extends CompositeBinary {

	public CompositeMultiplication(BaseComponent right, BaseComponent left) {
		super(right, left);
	}

	@Override
	public int item() {
		return '*';
	}
}
