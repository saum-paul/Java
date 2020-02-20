package org.smacknologs.patterns.expressiontree.composite;

public class CompositeBinary extends CompositeUnary {

	private BaseComponent left;

	public CompositeBinary(BaseComponent left, BaseComponent right) {
		super(right);
		this.left = left;
	}

	@Override
	public BaseComponent left() {
		return this.left;
	}
}
