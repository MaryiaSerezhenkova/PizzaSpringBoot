package by.academy.pizza.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.pizza.api.core.Menu;
import by.academy.pizza.api.core.MenuRow;
import by.academy.pizza.api.dto.MenuDTO;
import by.academy.pizza.api.mapper.MenuMapper;
import by.academy.pizza.dao.MenuDao;
import by.academy.pizza.dao.api.IMenuDao;
import by.academy.pizza.service.api.IMenuService;
import by.academy.pizza.service.api.IPizzaInfoService;
@Service
public class MenuService implements IMenuService {

	private final MenuDao menuDao;
	private final PizzaInfoService pizzaInfoService;

	@Autowired
	public MenuService(MenuDao menuDao, PizzaInfoService pizzaInfoService) {
		super();
		this.menuDao = menuDao;
		this.pizzaInfoService = pizzaInfoService;
	}
	@Transactional
	@Override
	public Menu create(MenuDTO dto) {
		//entityManager.getTransaction().begin();
		Menu menu = this.menuDao.create(MenuMapper.menuInputMapping(dto));
		menu.setDtCreate(LocalDateTime.now());
		menu.setDtUpdate(menu.getDtCreate());
		menu.setName(dto.getName());
		menu.setEnabled(dto.isEnabled());
		menu.setItems(dto.getItems().stream()
				.map(i -> new MenuRow(this.pizzaInfoService.read(i.getPizzaInfo()), i.getPrice()))
				.collect(Collectors.toList()));
		return MenuMapper.menuOutputMapping(this.menuDao.create(menu));
	}
	@Transactional
	@Override
	public Menu read(long id) {
		return menuDao.read(id);
	}
	@Transactional
	@Override
	public List<Menu> get() {
		return menuDao.get();
	}
	@Transactional
	@Override
	public Menu update(long id, LocalDateTime dtUpdate, MenuDTO dto) {
		Menu readed = menuDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		readed.setDtUpdate(LocalDateTime.now());
		readed.setName(dto.getName());
		readed.setEnabled(dto.isEnabled());

		return menuDao.update(id, dtUpdate, readed);
	}
	@Transactional
	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		Menu readed = menuDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Меню не найдено");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
		}

		menuDao.delete(id, dtUpdate);

	}
	@Transactional
	@Override
	public MenuRow getRowById(long id) {
		return menuDao.readByRowId(id);
	}

}
