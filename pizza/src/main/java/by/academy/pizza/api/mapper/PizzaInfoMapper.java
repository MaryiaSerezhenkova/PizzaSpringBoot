package by.academy.pizza.api.mapper;

import by.academy.pizza.api.core.PizzaInfo;
import by.academy.pizza.api.dto.PizzaInfoDto;



public class PizzaInfoMapper {
	public PizzaInfoMapper() {
	}

	public static PizzaInfo pizzaInfoInputMapping(PizzaInfoDto pizzaInfoDto) {
		return new PizzaInfo(pizzaInfoDto.getName(), pizzaInfoDto.getDescription(), pizzaInfoDto.getSize());
	}

	public static PizzaInfo pizzaInfoOutputMapping(PizzaInfo pizzaInfo) {
		return new PizzaInfo(pizzaInfo.getId(), pizzaInfo.getDtCreate(), pizzaInfo.getDtUpdate(), pizzaInfo.getName(),
				pizzaInfo.getDescription(), pizzaInfo.getSize());
	}
}