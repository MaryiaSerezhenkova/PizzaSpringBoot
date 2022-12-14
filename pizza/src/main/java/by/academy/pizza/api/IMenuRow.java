package by.academy.pizza.api;

import by.academy.pizza.api.core.PizzaInfo;

public interface IMenuRow {
	PizzaInfo getInfo();

	void setPizzaInfo(PizzaInfo pizzaInfo);

	double getPrice();

	void setPrice(double price);

	long getId();
}