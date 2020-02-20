package org.smacknologs.patterns.expressiontree.bridge;

import org.smacknologs.patterns.expressiontree.interpreter.Interpreter;
import org.smacknologs.patterns.expressiontree.interpreter.PostOrderInterpreter;
import org.smacknologs.patterns.expressiontree.visitor.PrintVisitor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ExpressionTree et = new ExpressionTree(new CompositeAddition(new LeafOperand(2), new LeafOperand(4)));
		
		System.out.println(et.left().item());
		System.out.println(et.item());
		System.out.println(et.makeIterator("in-order").hasNext());*/
		
		Interpreter i = new PostOrderInterpreter();
		ExpressionTree et = i.interpret("4 3 +");
		et.accept(new PrintVisitor());
		
		

	}

}
