package by.academy.pizza.api.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import by.academy.pizza.api.ISelectedItem;
@Entity
@Table(name = "selected_items", schema="app")
public class SelectedItem implements ISelectedItem, Serializable {
	private static final long serialVersionUID = 1L;
	@OneToOne
    @JoinColumn(name = "row", referencedColumnName = "id")
	private MenuRow row;
    @Column
	private int count;
    
	@ManyToOne
    @JoinColumn(name = "order", referencedColumnName = "id")
	private Order order;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public SelectedItem() {
		super();
	}

	public SelectedItem(MenuRow row, int count, Order order) {
		super();
		this.row = row;
		this.count = count;
		this.order = order;
	}

	public SelectedItem(MenuRow row, int count) {
		this.row = row;
		this.count = count;
	}

	public void setSelectedItem(MenuRow row) {
		this.row = row;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MenuRow getRow() {
		return row;
	}

	public int getCount() {
		return count;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelectedItem [row=");
		builder.append(row);
		builder.append(", count=");
		builder.append(count);
		builder.append(", order=");
		builder.append(order);
		builder.append("]");
		return builder.toString();
	}

}