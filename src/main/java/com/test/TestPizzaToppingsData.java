package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configurations.springHibernateConfigurations.AppConfig;
import com.modelTable.PizzaToppingsTable;
import com.modelTable.PizzaVarietyTable;
import com.services.PizzaToppingsServiceI;
import com.services.PizzaToppingsServiceImpl;
import com.services.PlaceYourOrderI;
import com.services.PlaceYourOrderImpl;

public class TestPizzaToppingsData {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
	   PizzaToppingsServiceI pizzaTopping = (PizzaToppingsServiceI)appContext.getBean("PizzaToppingsService");
        
		System.out.println("Saving toppings data");
		/*
		 * PizzaToppingsTable pizzaTopData = new PizzaToppingsTable();
		 * pizzaTopData.setToppingName("Black Olives");
		 * pizzaTopData.setToppingPrice("40");
		 * 
		 * 
		 * PizzaToppingsTable pizzaTopData0 = new PizzaToppingsTable();
		 * pizzaTopData0.setToppingName("Crisp Capsicum");
		 * pizzaTopData0.setToppingPrice("30");
		 * 
		 * PizzaToppingsTable pizzaTopData1 = new PizzaToppingsTable();
		 * pizzaTopData1.setToppingName("Golden Corn");
		 * pizzaTopData1.setToppingPrice("40");
		 * 
		 * PizzaToppingsTable pizzaTopData2 = new PizzaToppingsTable();
		 * pizzaTopData2.setToppingName("Fresh Tomato");
		 * pizzaTopData2.setToppingPrice("45");
		 * 
		 * PizzaToppingsTable pizzaTopData3 = new PizzaToppingsTable();
		 * pizzaTopData3.setToppingName("Chunky Chicken");
		 * pizzaTopData3.setToppingPrice("50");
		 * 
		 * PizzaToppingsTable pizzaTopData4 = new PizzaToppingsTable();
		 * pizzaTopData4.setToppingName("Zesty chicken Sausage");
		 * pizzaTopData4.setToppingPrice("55");
		 * 
		 * PizzaToppingsTable pizzaTopData5 = new PizzaToppingsTable();
		 * pizzaTopData5.setToppingName("Black Olives");
		 * pizzaTopData5.setToppingPrice("60");
		 * 
		 * PizzaToppingsTable pizzaTopData6 = new PizzaToppingsTable();
		 * pizzaTopData6.setToppingName("Hot N Spicy Chicken");
		 * pizzaTopData6.setToppingPrice("65");
		 * 
		 * PizzaToppingsTable pizzaTopData7 = new PizzaToppingsTable();
		 * pizzaTopData7.setToppingName("Extra Cheese");
		 * pizzaTopData7.setToppingPrice("70");
		 * 
		 * 
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData0);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData1);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData2);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData3);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData4);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData5);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData6);
		 * pizzaTopping.savePizzaToppingsData(pizzaTopData7);
		 * System.out.println("Toppings data has been saved now.");
		 * 
		 */
		System.out.println("=======Fetching all available Toppings and price=====");
		List<PizzaToppingsTable> toppings = pizzaTopping.fetchAllToppings();
		for(PizzaToppingsTable listToppings : toppings)
		{
			System.out.println("ToppingName ="+listToppings.getToppingName());
			System.out.println("ToppingPrice ="+listToppings.getToppingPrice());
		}
		System.out.println(".............THANK YOU.......");
		
		
		System.out.println("......Now Selecting Insgle Topping............");
		List<PizzaToppingsTable> toppings1 =pizzaTopping.fetchByName("Zesty chicken Sausage");
		for(PizzaToppingsTable listToppings : toppings1)
		{
			System.out.println("ToppingName ="+ listToppings.getToppingName());
			System.out.println("ToppingPrice ="+ listToppings.getToppingPrice());
		}
		System.out.println("............DONE........................");
		
		System.out.println("===testing when Pizza is ordered along with Toppings");
		System.out.println("Placing Order..wait while calculating your bill ....");
		PlaceYourOrderI service = (PlaceYourOrderI) appContext.getBean("PlaceOrder") ;
		List<String> toppingsList = new ArrayList<String>();
		toppingsList.add("Golden Corn");
		toppingsList.add("Crisp Capsicum");
		toppingsList.add("Chunky Chicken");
        ((PlaceYourOrderImpl) service).placeOrder("Mexican Green Wave", "large", true, toppingsList);	
        System.out.println("Your Final Bill for Large Size Pizza without Toppings ="+((PlaceYourOrderImpl) service).showFinalBill());
        
	}

}
