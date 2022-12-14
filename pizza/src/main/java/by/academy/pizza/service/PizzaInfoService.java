package by.academy.pizza.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.pizza.api.IPizzaInfo;
import by.academy.pizza.api.core.PizzaInfo;
import by.academy.pizza.api.dto.PizzaInfoDto;
import by.academy.pizza.api.mapper.PizzaInfoMapper;
import by.academy.pizza.dao.PizzaInfoDao;
import by.academy.pizza.service.api.IPizzaInfoService;

@Service

public class PizzaInfoService implements IPizzaInfoService {
	

	private final PizzaInfoDao pizzaInfoDao;

	@Autowired
	public PizzaInfoService(PizzaInfoDao pizzaInfoDao) {
		super();
		this.pizzaInfoDao = pizzaInfoDao;
	}
	@Transactional
	public List<PizzaInfo> get() {
		return pizzaInfoDao.get();
	}


	@Override
	@Transactional
	public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDto item) {
		PizzaInfo readed = pizzaInfoDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		readed.setDtUpdate(LocalDateTime.now());
		readed.setName(item.getName());
		readed.setDescription(item.getDescription());
		readed.setSize(item.getSize());

		return pizzaInfoDao.update(id, dtUpdate, readed);
	}

	@Override
	@Transactional
	public void delete(long id, LocalDateTime dtUpdate) {
		IPizzaInfo readed = pizzaInfoDao.read(id);
		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		pizzaInfoDao.delete(id, dtUpdate);

	}

	@Override
	@Transactional
	public PizzaInfo create(PizzaInfoDto dto) {

		PizzaInfo pizzaInfo = PizzaInfoMapper.pizzaInfoInputMapping(dto);
		pizzaInfo.setDtCreate(LocalDateTime.now());
		pizzaInfo.setDtUpdate(pizzaInfo.getDtCreate());
		return PizzaInfoMapper.pizzaInfoOutputMapping(pizzaInfoDao.create(pizzaInfo));
	}

	@Override
	@Transactional
	public PizzaInfo read(long id) {
		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.read(id));
	}
	  

}
