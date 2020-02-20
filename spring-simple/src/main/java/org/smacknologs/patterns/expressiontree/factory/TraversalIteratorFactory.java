package org.smacknologs.patterns.expressiontree.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.smacknologs.patterns.expressiontree.bridge.ExpressionTree;
import org.smacknologs.patterns.expressiontree.iterator.InOrderIterator;
import org.smacknologs.patterns.expressiontree.iterator.PreOrderIterator;

public class TraversalIteratorFactory {
	private Map<String, IteratorFactoryAPI> interatorMap;

	public TraversalIteratorFactory() {
		interatorMap = new HashMap<String, TraversalIteratorFactory.IteratorFactoryAPI>();
		interatorMap.put("in-order", (e) -> new InOrderIterator<ExpressionTree>(e));
		interatorMap.put("pre-order", (e) -> new PreOrderIterator<ExpressionTree>(e));
	}

	private interface IteratorFactoryAPI {
		Iterator<ExpressionTree> execute(ExpressionTree e);
	}

	public Iterator<ExpressionTree> makeIterator(ExpressionTree e, String traversalOrder) {
		return interatorMap.get(traversalOrder).execute(e);
	}

}
