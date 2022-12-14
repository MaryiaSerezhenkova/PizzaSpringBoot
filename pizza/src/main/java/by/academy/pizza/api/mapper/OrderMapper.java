package by.academy.pizza.api.mapper;

import by.academy.pizza.api.IOrder;
import by.academy.pizza.api.core.Order;
import by.academy.pizza.api.dto.OrderDTO;


public class OrderMapper {
	
	 public OrderMapper() {
		super();
	}

	public static IOrder orderInputMapping(OrderDTO order) {
	        return new Order(order.getSelectedItems());
	    }

	    public static Order orderOutputMapping(IOrder order) {
	        return new Order(order.getId(), order.getDtCreate(), order.getDtUpdate(), order.getSelected());
	    }

}
