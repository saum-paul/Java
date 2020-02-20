package org.smacknologs.patterns.expressiontree.visitor;

import java.util.Stack;

import org.smacknologs.patterns.expressiontree.composite.CompositeAddition;
import org.smacknologs.patterns.expressiontree.composite.CompositeBinary;
import org.smacknologs.patterns.expressiontree.composite.CompositeMultiplication;
import org.smacknologs.patterns.expressiontree.composite.CompositeNegate;
import org.smacknologs.patterns.expressiontree.composite.CompositeUnary;
import org.smacknologs.patterns.expressiontree.composite.LeafOperand;

public class EvaluateVIsitor implements ExpressionTreeVisitor {

	private Stack<Integer> mStack = new Stack<>();

	@Override
	public void visit(LeafOperand comp) {
		// TODO Auto-generated method stub
		mStack.push(comp.item());
	}

	@Override
	public void visit(CompositeUnary comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CompositeNegate comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CompositeBinary comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CompositeAddition comp) {
		if (mStack.size() >= 2) {
			mStack.push(mStack.pop() + mStack.pop());
		}
	}

	@Override
	public void visit(CompositeMultiplication comp) {
		// TODO Auto-generated method stub

	}

	public int total() {
		if (mStack.isEmpty())
			return 0;
		else
			return mStack.peek();
	}

}
