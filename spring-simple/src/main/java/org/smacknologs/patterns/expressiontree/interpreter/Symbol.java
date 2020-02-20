package org.smacknologs.patterns.expressiontree.interpreter;

abstract class Symbol {
	Symbol right;
	Symbol left;
	int precedence;

	Symbol(Symbol l, Symbol r, int precedence) {
		right = r;
		left = l;
		this.precedence = precedence;
	}

	int getPrecedence() {
		return precedence;
	}
}

abstract class UnaryOperator extends Symbol {

	UnaryOperator(Symbol r, int precedence) {
		super(null, r, precedence);
	}
}

abstract class BinaryOperator extends Symbol {

	BinaryOperator(Symbol l, Symbol r, int precedence) {
		super(l, r, precedence);
	}
}