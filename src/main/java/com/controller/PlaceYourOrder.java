package com.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.modelTable.PizzaVarietyTable;
import com.pojo.PlaceOrderPojo;
import com.services.PlaceYourOrderI;

@Controller
public class PlaceYourOrder {

	
	@Autowired
	PlaceYourOrderI placeYourOrder;
	
	PlaceOrderPojo pojo;
	
	private static final Logger log =  Logger.getLogger(PlaceYourOrder.class);
	
	@Autowired
	PlaceYourOrderI order;
	
	/*
	 * @RequestMapping(value = "/") public ModelAndView getAllPizzas(ModelAndView
	 * model) { order.placeOrder("Margherita", "small", false); }
	 */
	
	@RequestMapping(value = "/placeYourorder",  method = RequestMethod.POST)
	public ModelAndView placeYourOrder(@ModelAttribute PizzaVarietyTable orderPizza)
	{
	     //pojo = new PlaceOrderPojo();
		 placeYourOrder.placeOrder(orderPizza.getPizzaName(), "small", false);
		/*
		 * String pizzaName = request.getParameter("pizzaName"); String pizzaType =
		 * request.getParameter("pizzaType"); String addToppings =
		 * request.getParameter("yesOrNo"); order.placeOrder(pizzaName, pizzaType,
		 * false);
		 */
		 return new ModelAndView("redirect:/");
	}
}

