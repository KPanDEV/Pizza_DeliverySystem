package com.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.PizzaVarietyDaoI;
import com.modelTable.PizzaVarietyTable;

public interface PizzaVariety {
	
	@SuppressWarnings("rawtypes")
	public List<PizzaVarietyTable> fetchAllPizza();
	
	public Map fetchPizzaSize(List <String> onSize);
	
	public void savePizzaDataVendors(PizzaVarietyTable pizzaData);
	
	public List<PizzaVarietyTable> fetchPizza(String pizzaName);

}
