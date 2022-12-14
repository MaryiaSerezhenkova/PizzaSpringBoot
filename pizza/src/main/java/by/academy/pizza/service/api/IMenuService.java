package by.academy.pizza.service.api;

import by.academy.pizza.api.IMenuRow;
import by.academy.pizza.api.core.Menu;
import by.academy.pizza.api.dto.MenuDTO;

public interface IMenuService extends IService<Menu, MenuDTO> {
	IMenuRow getRowById(long id);

}
