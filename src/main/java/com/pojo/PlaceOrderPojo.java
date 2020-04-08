package com.pojo;

import com.services.PlaceYourOrderImpl;

public class PlaceOrderPojo extends PlaceYourOrderImpl {

	public String pizzaName;
	
	public String pizzaType;
	
	public Boolean yOrN;

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	@Override
	public String toString() {
		return "PlaceOrderPojo [pizzaName=" + pizzaName + ", pizzaType=" + pizzaType + ", yOrN=" + yOrN + "]";
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public Boolean getyOrN() {
		return yOrN;
	}

	public void setyOrN(Boolean yOrN) {
		this.yOrN = yOrN;
	}
	
	
	
	
}
