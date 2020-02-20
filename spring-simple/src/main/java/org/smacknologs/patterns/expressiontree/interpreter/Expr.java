package org.smacknologs.patterns.expressiontree.interpreter;

import org.smacknologs.patterns.expressiontree.composite.BaseComponent;
import org.smacknologs.patterns.expressiontree.composite.CompositeAddition;
import org.smacknologs.patterns.expressiontree.composite.CompositeMultiplication;
import org.smacknologs.patterns.expressiontree.composite.CompositeNegate;
import org.smacknologs.patterns.expressiontree.composite.LeafOperand;

public interface Expr {

	int interpret();

	BaseComponent build();

	default boolean isEmpty() {

		return true;
	}
}

class NbrExpr implements Expr {

	private int nbr;

	public NbrExpr(int n) {
		nbr = n;
	}

	@Override
	public int interpret() {
		return nbr;
	}

	@Override
	public BaseComponent build() {
		return new LeafOperand(nbr);
	}

}

class NegateExpr implements Expr {
	private Expr rightExpr;

	public NegateExpr(Expr e) {
		rightExpr = e;
	}

	@Override
	public int interpret() {
		return -rightExpr.interpret();
	}

	@Override
	public BaseComponent build() {
		return new CompositeNegate(rightExpr.build());
	}

}

abstract class BinaryExpr implements Expr {

	Expr leftExpr;
	Expr rightExpr;

	public BinaryExpr(Expr l, Expr r) {
		leftExpr = l;
		rightExpr = r;
	}
}

class AddExpr extends BinaryExpr {

	public AddExpr(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public int interpret() {
		return rightExpr.interpret() + leftExpr.interpret();
	}

	@Override
	public BaseComponent build() {
		return new CompositeAddition(leftExpr.build(), rightExpr.build());
	}
}

class MultiplyExpr extends BinaryExpr {

	public MultiplyExpr(Expr l, Expr r) {
		super(l, r);
	}

	@Override
	public int interpret() {
		return leftExpr.interpret() * rightExpr.interpret();
	}

	@Override
	public BaseComponent build() {
		return new CompositeMultiplication(rightExpr.build(), leftExpr.build());
	}
}
