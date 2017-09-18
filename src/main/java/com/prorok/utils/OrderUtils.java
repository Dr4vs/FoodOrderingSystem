package com.prorok.utils;

import java.util.List;
import java.util.Scanner;

import com.prorok.model.Dessert;
import com.prorok.model.Drink;
import com.prorok.model.Item;
import com.prorok.model.MainCourse;
import com.prorok.model.Order;
import com.prorok.restaurant.Cuisine;

/**
 * Class represent somebody like waitress. Ask as what we want to eat, drink and creates order. 
 * @author dp7
 *
 */
public class OrderUtils {

	
	/**
	 * Method for ordering 
	 * @param cuisine Our chosen cuisine
	 * @param sc Scanner for input our select
	 * @return
	 */
	public Order takeOrder(Cuisine cuisine, Scanner sc) {

		Order order = new Order();
		int choice = -1;

		while (choice != 3) {
			System.out.println("1. Order Lunch: ");
			System.out.println("2. Order Drink: ");
			System.out.println("3. Finish order");
			boolean isChoosen = false;
			while(!isChoosen) {
			try {
			choice = Integer.parseInt(sc.nextLine());
			isChoosen=true;
			}catch(NumberFormatException e) {
				System.err.println("Wrong choice. Choose again :");
			}
			}
			switch (choice) {
			case 1:
				orderLunch(cuisine.getItems(), order, sc);
				break;
			case 2:
				orderDrink(cuisine.getItems(), order, sc);
				break;
			case 3:
				order.getItems().forEach(x->order.setBill(order.getBill()+x.getPrice()));
				break;
			default:
				System.err.println("Wrong choice. Choose again :");
			}
		}
		return order;
	}

	
	/**
	 * Method to order Drink by number on the list 
	 * @param items List possible items to the order
	 * @param order Order with list items and bill 
	 * @param sc Scanner for input our select
	 */
	private void orderDrink(List<Item> items, Order order, Scanner sc) {
		System.out.println("Please choose drink: ");
		items.stream().filter(Drink.class::isInstance).forEach(System.out::println);
		String choices;
		do {
		 choices = sc.nextLine();}
		while(!choices.matches("[1-9]") || Integer.parseInt(choices)>items.stream().filter(Drink.class::isInstance).count());
		int choice = Integer.parseInt(choices);
		Item item = items.stream().filter(Drink.class::isInstance).skip(choice-1).limit(choice).findFirst().get();
//		String drink = sc.nextLine();
//		Item item = items.stream().filter(x -> x.getName().equalsIgnoreCase(drink)).findFirst().get();
		System.out.println("Would you like any ice? Y/N");
		if (sc.nextLine().equalsIgnoreCase("Y")) {
			((Drink) item).setContainsIce(true);
		}
		System.out.println("Would you like some Lemon? Y/N");
		if (sc.nextLine().equalsIgnoreCase("Y")) {
			((Drink) item).setContainsLemon(true);
		}
		order.getItems().add(item);
	}

	/**
	 * Method to order Lunch (main course + dessert) by number on the list 
	 * @param items List possible items to the order
	 * @param order Order with list items and bill 
	 * @param sc Scanner for input our select
	 */
	
	private void orderLunch(List<Item> items, Order order, Scanner sc) {
		System.out.println("Please choose main course: ");
		items.stream().filter(MainCourse.class::isInstance).forEach(System.out::println);
		String choices;
		do {
		 choices = sc.nextLine();}
		while(!choices.matches("[1-9]+") || Integer.parseInt(choices)>items.stream().filter(MainCourse.class::isInstance).count());
		int choice = Integer.parseInt(choices);
		Item item = items.stream().filter(MainCourse.class::isInstance).skip(choice-1).limit(choice).findFirst().get();	
//		String mainCourse = sc.nextLine();
//		Item item = items.stream().filter(x -> x.getName().equalsIgnoreCase(mainCourse)).findFirst().get();
		order.getItems().add(item);
		System.out.println("Please choose dessert (name): ");
		items.stream().filter(Dessert.class::isInstance).forEach(System.out::println);
		String choices2;
		do {
		 choices2 = sc.nextLine();}
		while(!choices2.matches("[1-9]+") || Integer.parseInt(choices2)>items.stream().filter(Dessert.class::isInstance).count());
		int choice2 = Integer.parseInt(choices2);
		Item item2 = items.stream().filter(Dessert.class::isInstance).skip(choice2-1).limit(choice2).findFirst().get();	
//		String dessert = sc.nextLine();
//		Item item2 = items.stream().filter(x -> x.getName().equalsIgnoreCase(dessert)).findFirst().get();
		order.getItems().add(item2);
	}

	/**
	 * Method to print bill. All ordered foods, drink and price for it
	 * @param order
	 */
	public void printBill(Order order) {
		System.out.println("Bill: ");
		order.getItems().forEach(System.out::println);
		System.out.println(order.getBill());
	}
}
