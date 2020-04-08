package com.services;

import java.util.List;

import com.modelTable.PizzaToppingsTable;
import com.modelTable.PizzaVarietyTable;

public interface PizzaToppingsServiceI {
	
	public void savePizzaToppingsData(PizzaToppingsTable entity);
	
     List<PizzaToppingsTable> fetchAllToppings();
     
     List<PizzaToppingsTable>fetchByName(String toppingnName);
	

}
