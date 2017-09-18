package com.prorok.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to take order from the client.  
 * @author dp7
 * @param items List all orders take it here for count and print the bill
 * @param bill Value to pay by client represented by double
 */
public class Order {

	private List<Item> items;
	private double bill;
	

	public Order() {
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
}
