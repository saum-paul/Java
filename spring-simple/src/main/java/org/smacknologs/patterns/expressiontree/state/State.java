package org.smacknologs.patterns.expressiontree.state;

import org.smacknologs.patterns.expressiontree.bridge.ExpressionTree;

class TreeContext {
	private State currentState;
	private ExpressionTree mTree;
	
	public TreeContext() {
		currentState = new State.InOrderUnInitializedState();
	}
	
	void setState(State s) {
		currentState = s;
	}
	
	State getState() {
		return currentState;
	}

	void makeTree(String expr) {
		currentState.makeTree(this, expr);
	}

	void format(String format) {
		currentState.format(this, format);
	}

}
public abstract class State {

	abstract void makeTree(TreeContext context, String expr);
	abstract void format(TreeContext context, String format);
	
	static class UnInitializedState extends State {

		@Override
		void makeTree(TreeContext context, String expr) {
			throw new IllegalStateException();
		}

		@Override
		void format(TreeContext context, String format) {

		}

	}

	static class InOrderUnInitializedState extends UnInitializedState {

		@Override
		void makeTree(TreeContext context, String expr) {
			context.setState(new InOrderInitializedState());

		}

		@Override
		void format(TreeContext context, String format) {

		}

	}
	
	static class InOrderInitializedState extends InOrderUnInitializedState {

		@Override
		void makeTree(TreeContext context, String expr) {

		}

		@Override
		void format(TreeContext context, String format) {

		}

	}
}


