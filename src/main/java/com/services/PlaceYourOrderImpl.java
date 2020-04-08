package com.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.configurations.springHibernateConfigurations.AppConfig;
import com.dao.PizzaVarietyDaoImpl;
import com.modelTable.PizzaToppingsTable;
import com.modelTable.PizzaVarietyTable;

@Service("PlaceOrder")
public class PlaceYourOrderImpl implements PlaceYourOrderI {

	
	  @Autowired 
	  PizzaVariety pizzaVariety;
	  
	  @Autowired
	  PizzaToppingsServiceI pizzaToppings;
	 
	 public String pizzaName;
	 
	 public String pizzaType;
	 
	 public Boolean yOrNo;
	 
	 private int smallPizzaPrice;
	 
	 private int mediumPizzaPrice;
	 
	 private int largePizzaPrice;
	 
	 public String pizzaTypeIdentifier;
	 
	 public int totalBill;
	 
	 public List<String>toppingName;
	 
	 public List<PizzaToppingsTable> toppingTableData;
	 
	 public int toppingPrice;
	 
	 public int getTotalBill() {
		return totalBill;
	}
 
	 public PizzaVariety getPizzaVariety() {
		return pizzaVariety;
	}

	public void setPizzaVariety(PizzaVariety pizzaVariety) {
		this.pizzaVariety = pizzaVariety;
	}

	public PizzaToppingsServiceI getPizzaToppings() {
		return pizzaToppings;
	}

	public void setPizzaToppings(PizzaToppingsServiceI pizzaToppings) {
		this.pizzaToppings = pizzaToppings;
	}

	public int getSmallPizzaPrice() {
		return smallPizzaPrice;
	}

	public void setSmallPizzaPrice(int smallPizzaPrice) {
		this.smallPizzaPrice = smallPizzaPrice;
	}

	public int getMediumPizzaPrice() {
		return mediumPizzaPrice;
	}

	public void setMediumPizzaPrice(int mediumPizzaPrice) {
		this.mediumPizzaPrice = mediumPizzaPrice;
	}

	public int getLargePizzaPrice() {
		return largePizzaPrice;
	}

	public void setLargePizzaPrice(int largePizzaPrice) {
		this.largePizzaPrice = largePizzaPrice;
	}

	public String getPizzaTypeIdentifier() {
		return pizzaTypeIdentifier;
	}

	public void setPizzaTypeIdentifier(String pizzaTypeIdentifier) {
		this.pizzaTypeIdentifier = pizzaTypeIdentifier;
	}

	public List<String> getToppingName() {
		return toppingName;
	}

	public void setToppingName(List<String> toppingName) {
		this.toppingName = toppingName;
	}

	public int getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(int toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public void selectPizzaName(String pizzaName) {
		setPizzaName(pizzaName);

	}

	public void selectPizzaType(String pizzaType) {
		setPizzaType(pizzaType);

	}

	public void selectPizzaToppings(Boolean yOrN) {
       setyOrNo(yOrN);

	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public Boolean getyOrNo() {
		return yOrNo;
	}

	public void setyOrNo(Boolean yOrNo) {
		this.yOrNo = yOrNo;
	}
	
	public int placeOrder(String pizzaName, String pizzaType, Boolean yOrNo)
	{
		selectPizzaName(pizzaName);
		selectPizzaType(pizzaType);
		selectPizzaToppings(yOrNo);
		return calculateBill();
	}
	
	public int placeOrder(String pizzaName, String pizzaType, Boolean yOrNo, List<String> toppingName)
	{
		selectPizzaName(pizzaName);
		selectPizzaType(pizzaType);
		selectPizzaToppings(yOrNo);
		setToppingName(toppingName);
		return calculateBill();
	}
	public int calculateBill()
	{
	  if(pizzaType.equals("small"))
		 {
			 setPizzaPrice(pizzaName);
			 checkToppingsN(yOrNo);
			 calculateFinalBill(smallPizzaPrice, pizzaType, yOrNo);
		 }
	  else if(pizzaType.equals("medium"))
	  {
		     setPizzaPrice(pizzaName);
			 checkToppingsN(yOrNo);
			 calculateFinalBill(smallPizzaPrice, pizzaType, yOrNo);
	  }
	  
	  else if(pizzaType.equals("large"))
	  {
		     setPizzaPrice(pizzaName);
			 checkToppingsN(yOrNo);
			 calculateFinalBill(smallPizzaPrice, pizzaType, yOrNo);
	  }
		return totalBill;
	}
	
	private void setPizzaPrice(String pizza)
	{
	   List<PizzaVarietyTable> pizzaList =((PizzaVariety) pizzaVariety).fetchPizza(pizzaName);	
	   for(PizzaVarietyTable list : pizzaList)
	      {
	    	  this.smallPizzaPrice = list.getSmallPizzaPrice();
	    	  this.mediumPizzaPrice = list.getMediumPizzaPrice();
	    	  this.largePizzaPrice = list.getLargePizzaPrice();
	       }
	}
	
	private int calculateFinalBill(int PizzaPrice, String pizzaType, Boolean yesOrNo)
	{
		if(yesOrNo.equals(false) )
		{
		   if( pizzaType.equals("small"))
		   {
			this.totalBill = smallPizzaPrice;
		   }
		   
		   else if(pizzaType.equals("medium"))
		   {
			   this.totalBill = mediumPizzaPrice;
		   }
		   
		   else if(pizzaType.equals("large"))
		   {
			   this.totalBill = largePizzaPrice;
		   }
		   
		}
		  else
		   { 
			  if( pizzaType.equals("small"))
			   {
			    fetchToppingPrice();  
				addTopinngPtoPizzaPrice(smallPizzaPrice, toppingPrice);
			   }
			  else if( pizzaType.equals("medium"))
			   {
			    fetchToppingPrice();  
				addTopinngPtoPizzaPrice(mediumPizzaPrice, toppingPrice);
			   }
			  
			  else if( pizzaType.equals("large"))
			   {
			    fetchToppingPrice();  
				addTopinngPtoPizzaPrice(largePizzaPrice, toppingPrice);
			   }
		   }
		
		
		return totalBill;
	}
	
	public Boolean checkToppingsN(Boolean toppingsValue)
	{
		if(yOrNo.equals(true))
		 {
			this.yOrNo = toppingsValue;
		 }
		return this.yOrNo;
	}
	
	public int showFinalBill()
	{
		return totalBill;
	}
	
	public void fetchToppingPrice()
	{
		List<PizzaToppingsTable> toppingsPrice = pizzaToppings.fetchAllToppings();
		toppingTableData = toppingsPrice;
		   for(PizzaToppingsTable list : toppingTableData)
		      {
			   for(String toppingList1 : toppingName )
			   {  
				   if(toppingList1.equals(list.getToppingName()))
				   {
					  mutlipleToppings(list.getToppingPrice());   
				   }
			      
		       }
		      }
	}
	
	public void addTopinngPtoPizzaPrice(int pizzaPrice, int toppingPrice)
	{
		this.totalBill = (pizzaPrice+toppingPrice);
	}
	
	public void mutlipleToppings(int price)
	{
		toppingPrice = (this.toppingPrice+price);
	}

}
