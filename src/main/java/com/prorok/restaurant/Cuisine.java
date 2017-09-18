package com.prorok.restaurant;

import java.util.List;
import com.prorok.model.Dessert;
import com.prorok.model.Drink;
import com.prorok.model.Item;
import com.prorok.model.MainCourse;

/**
 * Abstract class is representation cuisine.
 * All cuisines in our menu must extends this class.
 * Now we can easily add new cuisine.
 * @author dp7
 * @param items List of possible foods and drink to order
 * @param separator String used to separate position in menu 
 */
public abstract class Cuisine {
	
	protected List<Item> items;

	private String separator = "///////////////////////////";
	
	abstract void greetings();
	
	/**
	 * Public method used to print menu on console
	 */
	public void showMenu() {
		greetings();
		System.out.println(separator);
		System.out.println("Main courses:");
		items.stream().filter(MainCourse.class::isInstance).forEach(System.out::println);
		System.out.println(separator);
		System.out.println("Dessert:");
		items.stream().filter(Dessert.class::isInstance).forEach(System.out::println);
		System.out.println(separator);
		System.out.println("Drinks:");
		items.stream().filter(Drink.class::isInstance).forEach(System.out::println);	
		System.out.println(separator);
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
