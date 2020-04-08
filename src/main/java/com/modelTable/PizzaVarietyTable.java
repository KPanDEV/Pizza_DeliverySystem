package com.modelTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.services.PizzaVariety;

@Entity
@Table(name = "PizzaVariety")
public class PizzaVarietyTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="pizzaName" ,unique = true, nullable = false)
	private String pizzaName;
	
	@Column(name="smallPizzaPrice")
	public int smallPizzaPrice;
	
	@Column(name= "mediumPizzaPrice")
	public int mediumPizzaPrice;
	
	@Column(name="largePizzaPrice")
	public int largePizzaPrice;

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

	public int getSmallPizzaPrice() {
		return smallPizzaPrice;
	}

	public void setSmallPizzaPrice(int smallPizzaPrice) {
		this.smallPizzaPrice = smallPizzaPrice;
	}

	public int getMediumPizzaPrice() {
		return mediumPizzaPrice;
	}

	public void setMediumPizzaPrice(int mediumPizzaPrice) {
		this.mediumPizzaPrice = mediumPizzaPrice;
	}

	public int getLargePizzaPrice() {
		return largePizzaPrice;
	}

	public void setLargePizzaPrice(int largePizzaPrice) {
		this.largePizzaPrice = largePizzaPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + largePizzaPrice;
		result = prime * result + mediumPizzaPrice;
		result = prime * result + ((pizzaName == null) ? 0 : pizzaName.hashCode());
		result = prime * result + smallPizzaPrice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVarietyTable other = (PizzaVarietyTable) obj;
		if (id != other.id)
			return false;
		if (largePizzaPrice != other.largePizzaPrice)
			return false;
		if (mediumPizzaPrice != other.mediumPizzaPrice)
			return false;
		if (pizzaName == null) {
			if (other.pizzaName != null)
				return false;
		} else if (!pizzaName.equals(other.pizzaName))
			return false;
		if (smallPizzaPrice != other.smallPizzaPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PizzaVarietyTable [id=" + id + ", pizzaName=" + pizzaName + ", smallPizzaPrice=" + smallPizzaPrice
				+ ", mediumPizzaPrice=" + mediumPizzaPrice + ", largePizzaPrice=" + largePizzaPrice + "]";
	}

	
	
}