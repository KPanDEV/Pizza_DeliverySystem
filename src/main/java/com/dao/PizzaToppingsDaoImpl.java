package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.modelTable.PizzaToppingsTable;
import com.modelTable.PizzaVarietyTable;

@Repository("pizzaToppingsDao")
public class PizzaToppingsDaoImpl extends AbstractPizzaProcessDao implements PizzaToppingsDaoI {

	
	public void savePizzaToppingsData(PizzaToppingsTable entity) {
	      	savePizzaEntriesVendor(entity);
	}

	
	public List<PizzaToppingsTable> fetchAllAvailableToppings() {
		Criteria criteria = getCurrentSession().createCriteria(PizzaToppingsTable.class);
		return ((List<PizzaToppingsTable>)criteria.list());
	}
	
	public List<PizzaToppingsTable> fetchToppingsByName(String toppingName)
	{
	   Criteria criteria = getCurrentSession().createCriteria(PizzaToppingsTable.class);
	   criteria.add(Restrictions.eq("toppingName", toppingName));
       return( (List<PizzaToppingsTable>)criteria.list());	
	}

	
}
