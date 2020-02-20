package org.smacknologs.patterns.expressiontree.composite;

import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public interface BaseComponent {

	public default int item() {
		throw new UnsupportedOperationException();
	}

	public default BaseComponent left() {
		return null;
	}

	public default BaseComponent right() {
		return null;
	}
	
	public void accept(ExpressionTreeVisitor v);
}
