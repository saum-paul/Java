package org.smacknologs.patterns.expressiontree.builder;

public class DahiPapdiChat {

	private int salt;
	private int sugar;
	private int dahi;

	private DahiPapdiChat(int dahi, int salt, int sugar) {
		this.salt = salt;
		this.sugar = sugar;
		this.dahi = dahi;
	}

	private static class DahiPapdiChatBuilder {
		private int salt;
		private int sugar;
		private int dahi;

		public DahiPapdiChat build() {
			return new DahiPapdiChat(dahi, salt, sugar);
		}

		public DahiPapdiChatBuilder addDahi(int q) {
			this.dahi = q;
			return this;
		}

		public DahiPapdiChatBuilder addSalt(int q) {
			this.salt = q;
			return this;
		}

		public DahiPapdiChatBuilder addSugar(int q) {
			this.sugar = q;
			return this;
		}
	}

}
