package com.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.configurations.springHibernateConfigurations.AppConfig;
import com.modelTable.PizzaVarietyTable;
import com.pojo.PlaceOrderPojo;
import com.services.PizzaVariety;
import com.services.PizzaVarietyImpl;
import com.services.PlaceYourOrderI;
import com.services.PlaceYourOrderImpl;

public class TestPizzaVarietyImpl {
	private static final Logger logger = Logger.getLogger(TestPizzaVarietyImpl.class);

	private PizzaVarietyImpl pizzaVariety = null;
	public static void main(String[] args) {
		System.out.println("Scanning Subpackages");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("Initializing bean");
		PizzaVariety service = (PizzaVariety) context.getBean("PizzaVarietyService");
		
		//Will test the Fetch operations later
		/*
		 * PizzaVarietyTable varietyTable = new PizzaVarietyTable();
		 * varietyTable.getPizzaName();
		 */
		
		System.out.println("Setting Pizza related data");
		
		//First will insert the data under table
		/*
		 * PizzaVarietyTable varietyTable1 = new PizzaVarietyTable();
		 * varietyTable1.setPizzaName("Margherita");
		 * varietyTable1.setMediumPizzaPrice(180); varietyTable1.setSmallPizzaPrice(75);
		 * varietyTable1.setLargePizzaPrice(330);
		 * 
		 * System.out.println("Involing save method to save data");
		 * service.savePizzaDataVendors(varietyTable1); logger.error(TestProject.class);
		 */
		
		/*
		 * PizzaVarietyTable varietyTable1 = new PizzaVarietyTable();
		 * varietyTable1.setPizzaName("Fresh Veggie");
		 * varietyTable1.setMediumPizzaPrice(235);
		 * varietyTable1.setSmallPizzaPrice(130); varietyTable1.setLargePizzaPrice(625);
		 * 
		 * PizzaVarietyTable varietyTable2 = new PizzaVarietyTable();
		 * varietyTable2.setPizzaName("Country Special");
		 * varietyTable2.setMediumPizzaPrice(245);
		 * varietyTable2.setSmallPizzaPrice(140); varietyTable2.setLargePizzaPrice(600);
		 * 
		 * PizzaVarietyTable varietyTable3 = new PizzaVarietyTable();
		 * varietyTable3.setPizzaName("Farmhouse");
		 * varietyTable3.setMediumPizzaPrice(250);
		 * varietyTable3.setSmallPizzaPrice(180); varietyTable3.setLargePizzaPrice(625);
		 * 
		 * PizzaVarietyTable varietyTable4 = new PizzaVarietyTable();
		 * varietyTable4.setPizzaName("Mexican Green Wave");
		 * varietyTable4.setMediumPizzaPrice(243);
		 * varietyTable4.setSmallPizzaPrice(145); varietyTable4.setLargePizzaPrice(620);
		 * 
		 * PizzaVarietyTable varietyTable5 = new PizzaVarietyTable();
		 * varietyTable5.setPizzaName("Barbeque Chicken");
		 * varietyTable5.setMediumPizzaPrice(225);
		 * varietyTable5.setSmallPizzaPrice(212); varietyTable5.setLargePizzaPrice(725);
		 * 
		 * PizzaVarietyTable varietyTable6 = new PizzaVarietyTable();
		 * varietyTable6.setPizzaName("Chicken Mexicana");
		 * varietyTable6.setMediumPizzaPrice(200);
		 * varietyTable6.setSmallPizzaPrice(149); varietyTable6.setLargePizzaPrice(555);
		 * 
		 * System.out.println("Involing save method to save data");
		 * service.savePizzaDataVendors(varietyTable1);
		 * service.savePizzaDataVendors(varietyTable2);
		 * service.savePizzaDataVendors(varietyTable3);
		 * service.savePizzaDataVendors(varietyTable4);
		 * service.savePizzaDataVendors(varietyTable5);
		 * service.savePizzaDataVendors(varietyTable6);
		 */
		
		
		
		//Fetching the available list of Pizza
		
		List<PizzaVarietyTable> fetchPizzaList =service.fetchAllPizza();   
		for(PizzaVarietyTable pizzaVariety : fetchPizzaList)
        {
        	System.out.println("============Available Pizza ====================");
        	System.out.println("PizzaName: -"+ pizzaVariety.getPizzaName()+"\n");
        	System.out.println("Medium Pizza Price ="+pizzaVariety.getMediumPizzaPrice()+"\n");
        	System.out.println("Small Pizza Price ="+pizzaVariety.getSmallPizzaPrice()+"\n");
        	System.out.println("Large Pizza Price ="+pizzaVariety.getLargePizzaPrice()+"\n");
        	System.out.println("======================================================");
        	}
		
		System.out.println("Fetching Pizz By name"+"\n");
		List<PizzaVarietyTable> pizzaName  = service.fetchPizza("Margherita");
		for(PizzaVarietyTable list : pizzaName ) {
		  System.out.println("Pizzaname ="+list.getPizzaName()+"\n");	
		  System.out.println("Medium Pizza Price ="+list.getMediumPizzaPrice()+"\n");
		  System.out.println("Small Pizza Price ="+list.getSmallPizzaPrice()+"\n");
		  System.out.println("Large Pizza Price ="+list.getLargePizzaPrice()+"\n");
		  
		  }
	    
		
		System.out.println("Placing Order..wait while calculating your bill ....");
		PlaceYourOrderI service1 = (PlaceYourOrderI) context.getBean("PlaceOrder"); 
        ((PlaceYourOrderImpl) service1).placeOrder("Margherita", "medium", false);	
        System.out.println("Your Final Bill for Medium Size Pizza without Toppings ="+((PlaceYourOrderImpl) service1).showFinalBill());
        
        System.out.println("Placing Order..wait while calculating your bill ....");
		PlaceYourOrderI service2 = (PlaceYourOrderI) context.getBean("PlaceOrder"); 
        ((PlaceYourOrderImpl) service2).placeOrder("Chicken Mexicana", "small", false);	
        System.out.println("Your Final Bill for Small Size Pizza without Toppings ="+((PlaceYourOrderImpl) service1).showFinalBill());

        
        System.out.println("Placing Order..wait while calculating your bill ....");
		PlaceYourOrderI service3 = (PlaceYourOrderI) context.getBean("PlaceOrder"); 
        ((PlaceYourOrderImpl) service3).placeOrder("Mexican Green Wave", "large", false);	
        System.out.println("Your Final Bill for Large Size Pizza without Toppings ="+((PlaceYourOrderImpl) service1).showFinalBill());
        
	}
	
	
	
	
    
}
