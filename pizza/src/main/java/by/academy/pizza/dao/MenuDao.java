package by.academy.pizza.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.academy.pizza.api.core.Menu;
import by.academy.pizza.api.core.MenuRow;
import by.academy.pizza.dao.api.IMenuDao;
@Repository
public class MenuDao implements IMenuDao {
	
	private final EntityManager entityManager;
	private static final String SELECT_SQL = "SELECT * from app.menu";
//	private static final String SELECT_ROW_BY_ID_SQL = "SELECT info.id, info.dt_create, info.dt_update, info.name,"
//			+ " info.description, info.size, \n"
//			+ "rows.price, items.count\n"
//			+ "	FROM app.selected_items AS items\n"
//			+ "	JOIN app.order AS ord ON items.order=ord.id\n"
//			+ "	JOIN app.menu_rows AS rows ON items.row=rows.id\n"
//			+ "	JOIN app.pizza_info AS info ON rows.pizza=info.id\n"
//			+ "	JOIN app.menu AS men ON men.id=rows.menu\n"
//			+ "	WHERE rows.id=?;";
@Autowired
	public MenuDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Menu create(Menu item) {
		try {
			entityManager.persist(item);
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}

	@Override
	public Menu read(long id) {
		try {
			Menu menu = entityManager.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public List<Menu> get() {
		try {
			List<Menu> menu = entityManager.createNativeQuery(SELECT_SQL).getResultList();
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public Menu update(long id, LocalDateTime dtUpdate, Menu type) {
		try {
			Menu menu = entityManager.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!menu.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			menu.setDtUpdate(type.getDtUpdate());
			menu.setName(type.getName());
			menu.setEnabled(type.isEnabled());
			menu.setItems(type.getItems());
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
		return type;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		try {
			Menu menu = entityManager.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			if (menu.getDtUpdate() == dtUpdate) {
				entityManager.remove(menu);
			}
			;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public MenuRow readByRowId(long id) {
//		try {
//			entityManager.getTransaction().begin();
//			MenuRow row = (MenuRow) entityManager.createQuery(SELECT_ROW_BY_ID_SQL).getSingleResult();
//			if (row == null) {
//				throw new Exception("Такой записи не существует");
//			}
			return null;
//		} catch (Exception e) {
//			throw new RuntimeException("При чтении данных произошла ошибка", e);
//		}
	}
}