package by.academy.pizza.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import by.academy.pizza.api.IOrder;
import by.academy.pizza.api.core.Order;
import by.academy.pizza.dao.api.IOrderDao;

public class OrderDao  implements IOrderDao {
	private final EntityManager entityManager;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update" + "FROM app.\"order\"";
	public OrderDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public IOrder create(IOrder item) {
		try {
			entityManager.persist(item);
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}
	@Override
	public IOrder read(long id) {
		try {
			Order order = entityManager.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			return order;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}


	@Override
	public List<IOrder> get() {
		try {
			List<IOrder> order = entityManager.createQuery(SELECT_SQL).getResultList();
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			return order;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public IOrder update(long id, LocalDateTime dtUpdate, IOrder type) {
		try {
			Order order = entityManager.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!order.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			order.setDtUpdate(type.getDtUpdate());
			order.setItems(type.getSelected());
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
		return type;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		try {
			Order order = entityManager.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!order.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			entityManager.remove(order);
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

}
