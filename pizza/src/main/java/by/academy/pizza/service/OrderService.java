package by.academy.pizza.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import by.academy.pizza.api.IOrder;
import by.academy.pizza.api.core.Order;
import by.academy.pizza.api.dto.OrderDTO;
import by.academy.pizza.api.mapper.OrderMapper;
import by.academy.pizza.dao.api.IOrderDao;
import by.academy.pizza.service.api.IMenuService;
import by.academy.pizza.service.api.IOrderService;

public class OrderService implements IOrderService {
	private final IOrderDao orderDao;
	private final IMenuService menuService;


	public OrderService(IOrderDao orderDao, IMenuService menuService) {
		super();
		this.orderDao = orderDao;
		this.menuService = menuService;
	}


	@Override
	public Order create(OrderDTO dto) {
		IOrder order = this.orderDao.create(OrderMapper.orderInputMapping(dto));
		order.setDtCreate(LocalDateTime.now());
		order.setDtUpdate(order.getDtCreate());
//		order.setItems(dto.getSelectedItems().stream()
//				.map(i -> new SelectedItem(this.menuService.read(i.getMenuRow(), i.getCount())
//				.collect(Collectors.toList()));
		return OrderMapper.orderOutputMapping(this.orderDao.create(order));
	}



	@Override
	public IOrder read(long id) {
		return  orderDao.read(id);
	}


	@Override
	public List<IOrder> get() {
		return orderDao.get();
	}


	@Override
	public IOrder update(long id, LocalDateTime dtUpdate, OrderDTO dto) {
		IOrder readed = orderDao.read(id);
		
				if (readed == null) {
					throw new IllegalArgumentException("Позиция не найдена");
				}
		
				if (!readed.getDtUpdate().isEqual(dtUpdate)) {
					throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
				}
		
				readed.setDtUpdate(LocalDateTime.now());
			//	readed.setItems(dto.getSelectedItems());
		
				return orderDao.update(id, dtUpdate, readed);
			}


	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		IOrder readed = orderDao.read(id);
		
		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		orderDao.delete(id, dtUpdate);
	}

//
}
