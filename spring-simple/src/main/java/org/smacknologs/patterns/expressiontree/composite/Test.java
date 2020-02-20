package org.smacknologs.patterns.expressiontree.composite;

import org.smacknologs.patterns.expressiontree.visitor.EvaluateVIsitor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseComponent two = new LeafOperand(2);
		BaseComponent three = new LeafOperand(3);
		BaseComponent add = new CompositeAddition(two, three);
		
		EvaluateVIsitor v = new EvaluateVIsitor();
		two.accept(v);
		three.accept(v);
		add.accept(v);
		System.out.println(v.total());
//		System.out.println(add.item());

	}

}
