package org.smacknologs.coffeeshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoffeeShopTest {
	
	@Test
	void testExpressoCost() {
		Beverage b = new Expresso();
		System.out.println(b.getDescription());
		assertEquals(1.0, b.cost());
	}
	
	@Test
	void testDoubleExpressoCost() {
		Beverage b = new Expresso();
		b = new Expresso(b);
		System.out.println(b.getDescription());
		assertEquals(2.0, b.cost());
	}

	@Test
	void testDoubleExpressoMilkCost() {
		Beverage b = new Expresso();
		b = new Expresso(b);
		b = new Milk(b);
		System.out.println(b.getDescription());
		assertEquals(2.5, b.cost());
	}
	
	@Test
	void testDecafMilkCost() {
		Beverage b = new Decaf();
		b = new Milk(b);
		System.out.println(b.getDescription());
		assertEquals(1.7, b.cost());
	}
}
