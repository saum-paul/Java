package org.smacknologs.patterns.expressiontree.interpreter;

import java.util.Stack;

import org.smacknologs.patterns.expressiontree.bridge.ExpressionTree;
import org.smacknologs.patterns.expressiontree.bridge.InstrumentedExpressionTree;

public class PostOrderInterpreter implements Interpreter {
	private int index = 0;
	private int len;

	@Override
	public Expr buildParseTree(String input) {
		len = input.length();

		Stack<Expr> s = new Stack<>();
		Expr rightEx;

		while (index < len) {
			char c = input.charAt(index);
			if(Character.isWhitespace(c))
				;
			else if (Character.isDigit(c)) {
				s.push(new NbrExpr(makeNumber(input, index)));
			} else {
				rightEx = s.pop();
				System.out.println("-" + rightEx.interpret());
				switch (c) {
				case '+':
					s.push(new AddExpr(s.pop(), rightEx));
					break;
				case '*':
					s.push(new MultiplyExpr(s.pop(), rightEx));
					break;
				}
			}
			index++;
		}
		System.out.println(s.size());
		System.out.println(s.peek().interpret());
		
		return s.peek();
	}
	
	private int makeNumber(String input, int startIndex) {
		StringBuilder sb = new StringBuilder();
		index = startIndex;
		char c = input.charAt(index);
		while (Character.isDigit(c)) {
			sb.append(c);
			index++;
			if (index < len)
				c = input.charAt(index);
			else 
				c = '\n';
		}
		index--;
		System.out.println(sb.toString());
		return Integer.parseInt(sb.toString());
	}

	@Override
	public ExpressionTree buildExpressionTree(Expr parseTree) {
		return new InstrumentedExpressionTree(parseTree.build());
	}

}
