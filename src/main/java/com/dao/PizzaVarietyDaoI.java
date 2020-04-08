package com.dao;

import java.util.List;

import com.modelTable.PizzaVarietyTable;
import com.services.PizzaVariety;

public interface PizzaVarietyDaoI {
	
	public List<PizzaVarietyTable> getAllVarietyPizza();
	
	public void savePizzaDetailsVendorEntry(PizzaVarietyTable pizzaData);
	
    public List<PizzaVarietyTable> getPizzaByName(String data);
}
