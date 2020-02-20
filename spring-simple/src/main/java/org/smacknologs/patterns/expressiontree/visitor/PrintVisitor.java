package org.smacknologs.patterns.expressiontree.visitor;

import org.smacknologs.patterns.expressiontree.composite.CompositeAddition;
import org.smacknologs.patterns.expressiontree.composite.CompositeBinary;
import org.smacknologs.patterns.expressiontree.composite.CompositeMultiplication;
import org.smacknologs.patterns.expressiontree.composite.CompositeNegate;
import org.smacknologs.patterns.expressiontree.composite.CompositeUnary;
import org.smacknologs.patterns.expressiontree.composite.LeafOperand;

public class PrintVisitor implements ExpressionTreeVisitor {
	
	@Override
	public void visit(LeafOperand comp) {
		System.out.println(comp.item());
	}

	@Override
	public void visit(CompositeUnary comp) {
//		System.out.println(comp.item());
	}

	@Override
	public void visit(CompositeNegate comp) {
		System.out.println("-");
	}

	@Override
	public void visit(CompositeBinary comp) {
//		System.out.println(comp.item());
	}

	@Override
	public void visit(CompositeAddition comp) {
		System.out.println("+");
	}

	@Override
	public void visit(CompositeMultiplication comp) {
		System.out.println("*");
	}

}
