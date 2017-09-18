package com.prorok.model;

/**
 * Class represent each position in menu
 * @author dp7
 * @param name  Name of each position (main course, dessert, drink)
 * @param price Price of each position
 */
public abstract class Item{

	private String name;
	private Double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
}
