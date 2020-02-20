package org.smacknologs.patterns.expressiontree.composite;

import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public class CompositeUnary implements BaseComponent {

	private BaseComponent right;

	public CompositeUnary(BaseComponent right) {
		super();
		this.right = right;
	}

	@Override
	public BaseComponent right() {
		return this.right;
	}

	@Override
	public void accept(ExpressionTreeVisitor v) {
		// TODO Auto-generated method stub
		
	}

}
