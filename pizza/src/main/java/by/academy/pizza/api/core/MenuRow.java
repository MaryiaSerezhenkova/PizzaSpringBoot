package by.academy.pizza.api.core;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import by.academy.pizza.api.IMenuRow;

@Entity
@Table(name = "menu_rows", schema="app")
public class MenuRow implements IMenuRow, Serializable {

	private static final long serialVersionUID = 1L;
	@OneToOne
    @JoinColumn(name = "pizza", referencedColumnName = "id")
	private PizzaInfo pizzaInfo;
	@Column
	private double price;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public MenuRow() {
		super();
	}

	public MenuRow(PizzaInfo pizzaInfo, double price) {
		super();
		this.pizzaInfo = pizzaInfo;
		this.price = price;
	}

	public PizzaInfo getInfo() {
		return pizzaInfo;
	}

	public void setPizzaInfo(PizzaInfo pizzaInfo) {
		this.pizzaInfo = pizzaInfo;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

}