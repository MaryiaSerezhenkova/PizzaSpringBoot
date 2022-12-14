package by.academy.pizza.api.mapper;

import by.academy.pizza.api.IMenuRow;
import by.academy.pizza.api.core.MenuRow;

public class MenuRowMapper {
//	public static IMenuRow menuRowInputMapping(MenuRowDTO menuRowDTO) {
//		return new MenuRow(menuRowDTO.getPizzaInfoId(), menuRowDTO.getPrice(), menuRowDTO.getMenuId());
//	}

	public static MenuRow menuRowOutputMapping(IMenuRow menuRow) {
		return new MenuRow(menuRow.getInfo(), menuRow.getPrice());
	}
}