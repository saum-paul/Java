package org.smacknologs.patterns.expressiontree.bridge;

import java.util.Iterator;

import org.smacknologs.patterns.expressiontree.composite.BaseComponent;
import org.smacknologs.patterns.expressiontree.factory.TraversalIteratorFactory;
import org.smacknologs.patterns.expressiontree.visitor.ExpressionTreeVisitor;

public class ExpressionTree {

	private BaseComponent root;
	private TraversalIteratorFactory tif;

	public ExpressionTree(BaseComponent root) {
		this.root = root;
		this.tif = new TraversalIteratorFactory();
	}

	public int item() {
		return this.root.item();
	}

	public ExpressionTree left() {
		return new ExpressionTree(this.root.left());
	}

	public ExpressionTree right() {
		return new ExpressionTree(this.root.right());
	}

	public void accept(ExpressionTreeVisitor v) {
		root.accept(v);
	}

	public Iterator makeIterator(String traversalOrder) {
		return tif.makeIterator(this, traversalOrder);
	}

}