package org.smacknologs.builder;

import org.smacknologs.builder.Cocktail.CocktailBuilder;
import org.smacknologs.builder.Cocktail.GARNISH;
import org.smacknologs.builder.Cocktail.LIQUORS;
import org.smacknologs.builder.Cocktail.MIXERS;

public class Bartender {

	public static void main(String[] args) {

		Cocktail manhattan = new CocktailBuilder("Manhattan")
				.addLiquor(LIQUORS.WHISKEY).addLiquor(LIQUORS.VERMOUTH)
				.addMixer(MIXERS.BITTERS).addGarnish(GARNISH.ORANGE_PEEL)
				.addIce().shake();
		
		manhattan.serve();

		Cocktail oldFashioned = new CocktailBuilder("Old Fashioned")
				.addLiquor(LIQUORS.WHISKEY).addMixer(MIXERS.BITTERS)
				.addMixer(MIXERS.SUGAR_SYRUP)
				.addGarnish(GARNISH.ORANGE_PEEL).shake();
		
		oldFashioned.serve();
	}

}


/*manhattan = new Cocktail("Manhattan", LIQUORS.WHISKEY,
LIQUORS.VERMOUTH, null, MIXERS.BITTERS, null,
GARNISH.ORANGE_PEEL, true);

manhattan = new Cocktail("Manhattan", LIQUORS.WHISKEY,
LIQUORS.VERMOUTH, MIXERS.BITTERS,
GARNISH.ORANGE_PEEL, true);

Cocktail oldFashioned = new Cocktail("Old Fashioned",
LIQUORS.WHISKEY, null, null, MIXERS.BITTERS,
MIXERS.SUGAR_SYRUP, GARNISH.ORANGE_PEEL, false);*/

/*Cocktail ginNTonic = new Cocktail("Gin n Tonic",
LIQUORS.GIN, null, null, MIXERS.TONIC_WATER,
null, GARNISH.LEMON, true);

ginNTonic = new Cocktail("Gin n Tonic",

LIQUORS.GIN, MIXERS.TONIC_WATER,
GARNISH.LEMON, true);*/