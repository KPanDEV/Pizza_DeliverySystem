package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.modelTable.PizzaVarietyTable;
import com.services.PizzaVariety;

@Repository("pizzaVarietyDao")
public class PizzaVarietyDaoImpl extends AbstractPizzaProcessDao implements PizzaVarietyDaoI {

	@Autowired
	PizzaVariety pizzaVariety;
	
	@Override
	public List<PizzaVarietyTable> getAllVarietyPizza() {
		Criteria fetchAllPizza = getCurrentSession().createCriteria(PizzaVarietyTable.class);
		return (List<PizzaVarietyTable>)fetchAllPizza.list();
	}

	@Override
	public void savePizzaDetailsVendorEntry(PizzaVarietyTable pizzaData) {
		savePizzaEntriesVendor(pizzaData);
		
	}

	@Override
	public List<PizzaVarietyTable> getPizzaByName(String pizzaName) {
		
        Criteria fetchPizzaBYname = getCurrentSession().createCriteria(PizzaVarietyTable.class);
        fetchPizzaBYname.add(Restrictions.eq("pizzaName", pizzaName));
        return (List<PizzaVarietyTable>)fetchPizzaBYname.list();
	}

}
