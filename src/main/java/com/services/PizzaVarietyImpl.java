package com.services;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PizzaVarietyDaoI;
import com.modelTable.PizzaVarietyTable;

@Service("PizzaVarietyService")
@Transactional
public class PizzaVarietyImpl implements PizzaVariety {

	@Autowired
	PizzaVarietyDaoI pizzaVarietyDaoI;
	
	@Override
	public List<PizzaVarietyTable> fetchAllPizza() {
		
		return (List<PizzaVarietyTable>) pizzaVarietyDaoI.getAllVarietyPizza();
	}

	@Override
	public Map fetchPizzaSize(List<String> onSize) {
	
		return null;
	}

	@Override
	public void savePizzaDataVendors(PizzaVarietyTable pizzaData) {
		pizzaVarietyDaoI.savePizzaDetailsVendorEntry(pizzaData);
		
	}

	@Override
	public List<PizzaVarietyTable> fetchPizza(String pizzaName) {
		
		return(pizzaVarietyDaoI.getPizzaByName(pizzaName)); 
	}

}
