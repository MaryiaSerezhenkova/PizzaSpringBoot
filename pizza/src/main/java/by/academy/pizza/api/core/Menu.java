package by.academy.pizza.api.core;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import by.academy.pizza.api.IMenu;
import by.academy.pizza.api.dto.MenuDTO.Row;


@Entity
@Table(name = "menu", schema="app")
public class Menu implements IMenu, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;
	@Column(name = "dt_update")
	private LocalDateTime dtUpdate;
	@Column
	private String name;
	@Column(name = "enable")
	private boolean enabled;
	@OneToMany
	@JoinColumn(name = "menu", referencedColumnName = "id")
	private List<MenuRow> items;

	public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, boolean enabled) {
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.name = name;
		this.enabled = enabled;
	}

	public Menu() {
	}

	public Menu(List<MenuRow> items) {
		this.items = items;
	}

	public Menu(String name, Boolean enable) {
		this.name = name;
		this.enabled = enable;
	}

	public Menu(Long id, String name, Boolean enable) {
		this.id = id;
		this.name = name;
		this.enabled = enable;
	}


	public Menu(String name, boolean enable, List<Row> items2) {
		this.name = name;
		this.enabled = enable;
		
	}

	public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, boolean enabled,
			List<MenuRow> items) {
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.name = name;
		this.enabled = enabled;
		this.items=items;
	}

	public long getId() {
		return id;
	}
	public LocalDateTime getDtCreate() {
		return dtCreate;
	}
	public LocalDateTime getDtUpdate() {
		return dtUpdate;
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public List<MenuRow> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Menu{" + "id=" + id + ", dtCreate=" + dtCreate + ", dtUpdate=" + dtUpdate + ", name='" + name + '\''
				+ ", enabled=" + enabled + '}';
	}

	public void setDtCreate(LocalDateTime dtCreate) {
		this.dtCreate = dtCreate;
	}

	public void setDtUpdate(LocalDateTime dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public void setId(long id) {
		this.id=id;
		
	}

	public void getItems(List<MenuRow> items) {
		return ;		
	}


	public void setItems(List<MenuRow> list) {
		this.items=list;
		
	}

}