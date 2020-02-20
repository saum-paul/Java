package org.smacknologs.patterns.expressiontree.composite;

import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public class LeafOperand implements BaseComponent {

	private int item;
	
	public LeafOperand(int i) {
		this.item = i;
	}

	@Override
	public int item() {
		return item;
	}

	@Override
	public void accept(ExpressionTreeVisitor v) {
		v.visit(this);
	}

}
