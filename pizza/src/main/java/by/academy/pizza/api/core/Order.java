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

import by.academy.pizza.api.IOrder;
import by.academy.pizza.api.dto.OrderDTO.Items;

@Entity
public class Order implements IOrder, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;
	@Column(name = "dt_update")
	private LocalDateTime dtUpdate;
	@OneToMany
	@JoinColumn(name = "order")
	private List<SelectedItem> selectedItems;

	public Order() {
		super();

	}

	public Order(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, List<SelectedItem> selectedItems) {
		super();
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.selectedItems = selectedItems;
	}

	public Order(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate) {
		super();
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
	}

	public Order(List<Items> items) {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(LocalDateTime dtCreate) {
		this.dtCreate = dtCreate;
	}

	public LocalDateTime getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(LocalDateTime dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	@Override
	public List<SelectedItem> getSelected() {
		return selectedItems;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", dtCreate=");
		builder.append(dtCreate);
		builder.append(", dtUpdate=");
		builder.append(dtUpdate);
		builder.append(", selectedItems=");
		builder.append(selectedItems);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void setItems(List<SelectedItem> items) {
		this.selectedItems = items;
		
	}

}