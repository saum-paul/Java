package org.smacknologs.patterns.expressiontree.bridge;

import org.smacknologs.patterns.expressiontree.composite.BaseComponent;
import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public class InstrumentedExpressionTree extends ExpressionTree {

	public InstrumentedExpressionTree(BaseComponent root) {
		super(root);
	}
	
	@Override
	public void accept(ExpressionTreeVisitor v) {
		System.out.println("Call ");
		super.accept(v);
	}

}
