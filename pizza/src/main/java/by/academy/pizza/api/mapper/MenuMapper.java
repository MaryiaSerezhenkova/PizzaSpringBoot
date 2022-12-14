package by.academy.pizza.api.mapper;

import by.academy.pizza.api.core.Menu;
import by.academy.pizza.api.dto.MenuDTO;

public class MenuMapper {
	
    public MenuMapper() {
		super();
	}

	public static Menu menuInputMapping(MenuDTO menu) {
        return new Menu(menu.getName(), menu.isEnabled(), menu.getItems());
    }

    public static Menu menuOutputMapping(Menu menu) {
        return new Menu(menu.getId(), menu.getDtCreate(), menu.getDtUpdate(), menu.getName(), menu.isEnabled(), menu.getItems());
    }

}