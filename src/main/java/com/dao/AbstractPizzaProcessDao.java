package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractPizzaProcessDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	protected Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public void processOrder(Object entity) {
	
		getCurrentSession().persist(entity);
	}
	
	public void processBaking(Object entity)
	{
		getCurrentSession().persist(entity);
	}
	
	public void orderReady(Object entity)
	{
		getCurrentSession().persist(entity);
	}
	
	public void orderStatus(Object entity)
	{
		getCurrentSession().persist(entity);
	}
	
	public void savePizzaEntriesVendor(Object entity)
	{
		getCurrentSession().persist(entity);
	}
	
}
