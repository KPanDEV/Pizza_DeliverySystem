package com.pojo;

import java.util.List;

public class PizzaVarietyTablePojo {

	private int id;
	
	private String pizzaName;
	
	private int smallSizePizzaPrice;
	
	private int mediumSizePizzaPrice;
	
	private int largeSizePizzaPrice;
	
	private String pizzaType;
	
	private Boolean addToppings;
	
	private List<String> toppingNames;
	
	private int toppingPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public int getSmallSizePizzaPrice() {
		return smallSizePizzaPrice;
	}

	public void setSmallSizePizzaPrice(int smallSizePizzaPrice) {
		this.smallSizePizzaPrice = smallSizePizzaPrice;
	}

	public int getMediumSizePizzaPrice() {
		return mediumSizePizzaPrice;
	}

	public void setMediumSizePizzaPrice(int mediumSizePizzaPrice) {
		this.mediumSizePizzaPrice = mediumSizePizzaPrice;
	}

	public int getLargeSizePizzaPrice() {
		return largeSizePizzaPrice;
	}

	public void setLargeSizePizzaPrice(int largeSizePizzaPrice) {
		this.largeSizePizzaPrice = largeSizePizzaPrice;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public Boolean getAddToppings() {
		return addToppings;
	}

	public void setAddToppings(Boolean addToppings) {
		this.addToppings = addToppings;
	}

	public List<String> getToppingNames() {
		return toppingNames;
	}

	public void setToppingNames(List<String> toppingNames) {
		this.toppingNames = toppingNames;
	}

	public int getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(int toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	
	
}
