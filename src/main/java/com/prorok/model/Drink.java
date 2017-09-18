package com.prorok.model;

/**
 * Class representation of the drink
 * @author dp7
 * @param containsIce Boolean value of Ice in drink
 * @param containsLemon Boolean value of Lemon in drink
 *	
 */
public class Drink extends Item {

	private boolean containsIce;
	private boolean containsLemon;

	/**
	 * This constructs drink with specified name and price
	 * @param name The name of the drink
	 * @param price The price of the drink
	 */
	public Drink(String name, Double price) {
		super(name, price);
	}

	public boolean isContainsIce() {
		return containsIce;
	}

	public void setContainsIce(boolean containsIce) {
		this.containsIce = containsIce;
	}

	public boolean isContainsLemon() {
		return containsLemon;
	}

	public void setContainsLemon(boolean containsLemon) {
		this.containsLemon = containsLemon;
	}

	@Override
	public String toString() {
		return "Name :" + getName() + ", price :" + getPrice() + " ice:" + (containsIce ? "Y" : "N") + " lemon:"
				+ (containsLemon ? "Y" : "N");
	}
}
