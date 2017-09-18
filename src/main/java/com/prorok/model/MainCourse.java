package com.prorok.model;

/**
 * Class representation of the Main Course
 * @author dp7
 */
public class MainCourse extends Item {

	
	/**
	 * This constructs main course with specified name and price
	 * @param name The name of the main course
	 * @param price The price of the main course
	 */
	public MainCourse(String name, Double price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "Name : "+ getName() + ", price : " + getPrice();
	}
}
