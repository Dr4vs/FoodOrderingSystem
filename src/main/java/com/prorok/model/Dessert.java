package com.prorok.model;

/**
 * Class representation of the dessert
 * @author dp7
 */

public class Dessert extends Item{

	/**
	 * This constructs dessert with specified name and price
	 * @param name The name of the dessert
	 * @param price The price of the dessert
	 */
	public Dessert(String name, Double price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "Name : "+ getName() + ", price : " + getPrice();
	}
}
