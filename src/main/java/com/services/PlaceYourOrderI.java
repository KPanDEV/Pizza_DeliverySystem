package com.services;

import java.util.List;

public interface PlaceYourOrderI {
	
	public void selectPizzaName(String pizzaName);
	
	public void selectPizzaType(String pizzaType);
	
	public void selectPizzaToppings(Boolean yOrN);
	
	public int placeOrder(String pizzaName, String pizzaType, Boolean yOrNo, List<String> toppingName);
	
	public int placeOrder(String pizzaName, String pizzaType, Boolean yOrNo);
	
	
}
