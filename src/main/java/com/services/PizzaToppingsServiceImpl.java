package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PizzaToppingsDaoI;
import com.modelTable.PizzaToppingsTable;
import com.modelTable.PizzaVarietyTable;

@Service("PizzaToppingsService")
@Transactional
public class PizzaToppingsServiceImpl implements PizzaToppingsServiceI {

	@Autowired
	PizzaToppingsDaoI pizzaDaoImpl;
	
	public void savePizzaToppingsData(PizzaToppingsTable pizzaTopData) {
		pizzaDaoImpl.savePizzaToppingsData(pizzaTopData);

	}

	public List<PizzaToppingsTable> fetchAllToppings() {
		return pizzaDaoImpl.fetchAllAvailableToppings();
	}
	

	
	public List<PizzaToppingsTable> fetchByName(String toppingnName) {
		return pizzaDaoImpl.fetchToppingsByName(toppingnName);
	}

	

	

}
