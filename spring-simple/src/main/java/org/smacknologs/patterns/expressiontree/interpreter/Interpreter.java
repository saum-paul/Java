package org.smacknologs.patterns.expressiontree.interpreter;

import org.smacknologs.patterns.expressiontree.bridge.ExpressionTree;

public interface Interpreter {

	default ExpressionTree interpret(String input) {
		Expr e = buildParseTree(input);
		return buildExpressionTree(e);

	}

	abstract ExpressionTree buildExpressionTree(Expr parseTree);

	Expr buildParseTree(String s);

}
