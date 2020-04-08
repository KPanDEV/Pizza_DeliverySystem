package com.dao;

import java.util.List;

import com.modelTable.PizzaToppingsTable;

public interface PizzaToppingsDaoI {
	
	public void savePizzaToppingsData(PizzaToppingsTable entity);
	
	List<PizzaToppingsTable> fetchAllAvailableToppings();
	
	List<PizzaToppingsTable> fetchToppingsByName(String name);

}
