package org.smacknologs.patterns.expressiontree.state;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeContext s = new TreeContext();
		s.makeTree("");
		
		System.out.println(s.getState().getClass());
	}

}
