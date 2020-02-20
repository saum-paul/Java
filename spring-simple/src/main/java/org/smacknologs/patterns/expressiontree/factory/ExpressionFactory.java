package org.smacknologs.patterns.expressiontree.factory;

import java.util.HashMap;
import java.util.Map;

import org.smacknologs.patterns.expressiontree.composite.BaseComponent;
import org.smacknologs.patterns.expressiontree.composite.CompositeNegate;
import org.smacknologs.patterns.expressiontree.composite.LeafOperand;

public class ExpressionFactory {

	private Map<String, ExpressionFactoryAPI> componentMap;
	private BaseComponent b;

	public ExpressionFactory() {
		componentMap = new HashMap<>();
		componentMap.put("leaf", (param) -> new LeafOperand(param));
		componentMap.put("negate", (param) -> new CompositeNegate(b));
	}

	private interface ExpressionFactoryAPI {

		BaseComponent makeNode(int i);

	}

}
