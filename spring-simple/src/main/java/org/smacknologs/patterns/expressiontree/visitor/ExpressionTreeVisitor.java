package org.smacknologs.patterns.expressiontree.visitor;

import org.smacknologs.patterns.expressiontree.composite.CompositeAddition;
import org.smacknologs.patterns.expressiontree.composite.CompositeBinary;
import org.smacknologs.patterns.expressiontree.composite.CompositeMultiplication;
import org.smacknologs.patterns.expressiontree.composite.CompositeNegate;
import org.smacknologs.patterns.expressiontree.composite.CompositeUnary;
import org.smacknologs.patterns.expressiontree.composite.LeafOperand;

public interface ExpressionTreeVisitor {
	void visit(LeafOperand comp);
	void visit(CompositeUnary comp);
	void visit(CompositeNegate comp);
	void visit(CompositeBinary comp);
	void visit(CompositeAddition comp);
	void visit(CompositeMultiplication comp);

}
