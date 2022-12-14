package by.academy.pizza.api;


import java.time.LocalDateTime;
import java.util.List;

import by.academy.pizza.api.core.SelectedItem;



/**
 * Заказ сформированный покупателем
 */
public interface IOrder {

	long getId();

	LocalDateTime getDtCreate();

	void setDtCreate(LocalDateTime dtCreate);

	LocalDateTime getDtUpdate();

	void setDtUpdate(LocalDateTime dtUpdate);

	/**
	 * Список выбранного для заказа
	 * 
	 * @return список выбранного
	 */
	List<SelectedItem> getSelected();

	void setItems(List<SelectedItem> items);


}
