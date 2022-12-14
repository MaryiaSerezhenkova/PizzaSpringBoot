package by.academy.pizza.api.mapper;

import by.academy.pizza.api.core.OrderStatus;

public class OrderStatusMapper {
	
		public OrderStatus orderOutputMapping(OrderStatus order) {
			return new OrderStatus(order.getTicket(), order.getHistory(), order.isDone());
		}

	}

