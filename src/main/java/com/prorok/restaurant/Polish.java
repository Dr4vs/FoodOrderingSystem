package com.prorok.restaurant;

import java.util.ArrayList;

import com.prorok.model.Dessert;
import com.prorok.model.Drink;
import com.prorok.model.MainCourse;

/**
 * One of possible cuisine in our Restaurant
 * @author dp7
 *
 */
public class Polish extends Cuisine {

	/**
	 * Constructor without fields. Inside we initialize new ArrayList with our possible items to order
	 */
	public Polish() {
		items=new ArrayList<>();
		items.add(new MainCourse("Meal1", 10.00));
		items.add(new MainCourse("Meal2", 12.00));
		items.add(new MainCourse("Meal3", 15.00));
		items.add(new MainCourse("Meal4", 18.00));
		items.add(new Dessert("Dessert1", 6.00));
		items.add(new Dessert("Dessert2", 4.50));
		items.add(new Dessert("Dessert3", 5.20));
		items.add(new Dessert("Dessert4", 5.40));
		items.add(new Dessert("Dessert5", 3.20));
		items.add(new Drink("Drink1", 5.00));
		items.add(new Drink("Drink2", 3.00));
		items.add(new Drink("Drink3", 4.00));	
	}
	
	/**
	 * Greetings when we choose this cuisine 
	 */
	@Override
	void greetings() {
		System.out.println("This is our Polish menu: ");		
	}
	
}
