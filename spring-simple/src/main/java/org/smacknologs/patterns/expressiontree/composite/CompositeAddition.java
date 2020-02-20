package org.smacknologs.patterns.expressiontree.composite;

import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public class CompositeAddition extends CompositeBinary {

	public CompositeAddition(BaseComponent left, BaseComponent right) {
		super(left, right);
	}

	@Override
	public int item() {
		return '+';
	}
	
	@Override
	public void accept(ExpressionTreeVisitor v) {
		super.accept(v);
		v.visit(this);
	}
}
