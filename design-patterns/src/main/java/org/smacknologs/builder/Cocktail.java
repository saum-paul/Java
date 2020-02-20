package org.smacknologs.builder;

import java.util.Objects;

public class Cocktail {

	private String name;
	private LIQUORS liquor1;
	private LIQUORS liquor2;
	private LIQUORS liquor3;
	private MIXERS mixer1;
	private MIXERS mixer2;
	private GARNISH garnish;
	private boolean addIce;
	private String display;

	enum LIQUORS {
		WHISKEY, VODKA, GIN, TRIPPLE_SEC, RUM, TEQUILLA, VERMOUTH
	}

	enum MIXERS {
		COKE, DIET_COKE, ORANGE_JUICE, SODA, BITTERS, SUGAR_SYRUP, TONIC_WATER
	}

	enum GARNISH {
		ORANGE_PEEL, MINT, SUGARGANE, OLIVE, LEMON
	}

	private Cocktail(CocktailBuilder builder) {
		this.name = Objects.requireNonNull(builder.name);
		this.liquor1 = Objects.requireNonNull(builder.liquor1);
		this.liquor2 = builder.liquor2;
		this.liquor3 = builder.liquor3;
		this.mixer1 = Objects.requireNonNull(builder.mixer1);
		this.mixer2 = builder.mixer2;
		this.garnish = builder.garnish;
		this.addIce = builder.addIce;
		this.display = builder.display;
	}

	public static class CocktailBuilder {
		private String name;
		private LIQUORS liquor1;
		private LIQUORS liquor2;
		private LIQUORS liquor3;
		private MIXERS mixer1;
		private MIXERS mixer2;
		private GARNISH garnish;
		private boolean addIce;
		private String display;

		public CocktailBuilder(String name) {
			this.name = name;
		}

		public CocktailBuilder addLiquor(LIQUORS l) {
			if (liquor1 == null)
				liquor1 = l;
			else if (liquor2 == null)
				liquor2 = l;
			else
				liquor3 = l;

			return this;
		}

		public CocktailBuilder addMixer(MIXERS m) {
			if (mixer1 == null)
				mixer1 = m;
			else
				mixer2 = m;
			return this;
		}

		public CocktailBuilder addGarnish(GARNISH g) {
			garnish = g;
			return this;
		}

		public CocktailBuilder addIce() {
			addIce = Boolean.TRUE;
			return this;
		}

		public Cocktail shake() {
			StringBuilder b = new StringBuilder(name);
			
			display = b.append(" [").append(liquor1).append(' ')
					.append(Objects.nonNull(liquor2) ? liquor2
							: "")
					.append(' ')
					.append(Objects.nonNull(liquor3) ? liquor3
							: "")
					.append(' ')
					.append(
							Objects.nonNull(mixer1) ? mixer1 : "")
					.append(' ')
					.append(
							Objects.nonNull(mixer2) ? mixer2 : "")
					.append(' ')
					.append(Objects.nonNull(garnish) ? garnish
							: "")
					.append(addIce ? ", poured over ICE]" : "]")
					.toString();
			return new Cocktail(this);
		}
	}

	public void serve() {
		System.out.println(this.display + this.hashCode());
	}
}

/*public Cocktail(String name, LIQUORS liquor1,
LIQUORS liquor2, LIQUORS liquor3, MIXERS mixer1,
MIXERS mixer2, GARNISH garnish, boolean addIce) {
this.name = name;
this.liquor1 = liquor1;
this.liquor2 = liquor2;
this.liquor3 = liquor3;
this.mixer1 = mixer1;
this.mixer2 = mixer2;
this.garnish = garnish;
this.addIce = addIce;
}

public Cocktail(String name, LIQUORS liquor1,
LIQUORS liquor2, MIXERS mixer1, GARNISH garnish,
boolean addIce) {
this.name = name;
this.liquor1 = liquor1;
this.liquor2 = liquor2;
this.mixer1 = mixer1;
this.garnish = garnish;
this.addIce = addIce;
}

public Cocktail(String name, LIQUORS liquor1,
MIXERS mixer1, GARNISH garnish, boolean addIce) {
this.name = name;
this.liquor1 = liquor1;
this.mixer1 = mixer1;
this.garnish = garnish;
this.addIce = addIce;
}*/
