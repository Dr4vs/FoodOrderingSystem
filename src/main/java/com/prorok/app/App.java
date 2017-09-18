package com.prorok.app;

import java.util.Scanner;

import com.prorok.model.Order;
import com.prorok.restaurant.Cuisine;
import com.prorok.restaurant.Italian;
import com.prorok.restaurant.Mexican;
import com.prorok.restaurant.Polish;
import com.prorok.utils.OrderUtils;

/**
 * @author dp7
 *	Runtime class
 */

public class App {
	public static void main(String[] args) {
		welcome();
		Scanner sc = new Scanner(System.in);
		Cuisine cuisine = chooseCuisine(sc);
		cuisine.showMenu();
		OrderUtils orderUtils = new OrderUtils();
		Order order = orderUtils.takeOrder(cuisine ,sc);
		orderUtils.printBill(order);
		sc.close();
	}

	/**
	 * Public method for welcome client in our restaurant 
	 * And show him available cuisines to choose
	 */
	public static void welcome() {
		System.out.println("Hello in our Restaurant.");
		System.out.println("Please choose cuisine: ");
		System.out.println("1. Polish");
		System.out.println("2. Mexican");
		System.out.println("3. Italian");		
	}
	
	/**
	 * The method in which we handle the selection 
	 * and then we create the object of the selected cuisine
	 * @param sc Scanner for input data
	 * @return Choosed cuisine  
	 */
	public static Cuisine chooseCuisine(Scanner sc) {
		boolean isCorrect;
		Cuisine cuisine = null;
		do {
		isCorrect = true;
		int choose = -1;
		boolean isChoosen = false;
		while(!isChoosen) {
		try{
			choose = Integer.parseInt(sc.nextLine());
			isChoosen = true;
		}catch(NumberFormatException e) {
			System.err.println("Wrong choose: ");
			}
		}
		switch(choose) {
		case 1:
			cuisine = new Polish();
			break;
			
		case 2:
			cuisine = new  Mexican();
			break;
			
		case 3:
			cuisine = new Italian();
			break;
			
		default:
			System.err.println("Wrong choose");
			isCorrect= false;
		}	
	}while(!isCorrect);
	return cuisine;
	}
}
