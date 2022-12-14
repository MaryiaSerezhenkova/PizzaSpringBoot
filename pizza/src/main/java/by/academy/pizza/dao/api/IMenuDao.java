package by.academy.pizza.dao.api;


import by.academy.pizza.api.core.Menu;
import by.academy.pizza.api.core.MenuRow;

public interface IMenuDao extends IDao<Menu> {

	MenuRow readByRowId(long id);

}
