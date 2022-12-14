package by.academy.pizza.api.core;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import by.academy.pizza.api.ITicket;
@Entity
public class Ticket implements ITicket, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;
	@Column
	private int number;
	@OneToOne
    @JoinColumn(name = "order", referencedColumnName = "id")
	private Order order;

	public Ticket(int number, Long orderId) {
		super();
		this.number = number;
		}

	public Ticket(long id, LocalDateTime dtCreate, int number, Order order) {
		super();
		this.id = id;
		this.dtCreate = dtCreate;
		this.number = number;
		this.order = order;
	}

	public Ticket() {
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
	@Override
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	
	@Override
	public LocalDateTime getCreatAt() {
		return dtCreate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [id=");
		builder.append(id);
		builder.append(", dtCreate=");
		builder.append(dtCreate);
		builder.append(", number=");
		builder.append(number);
		builder.append(", order=");
		builder.append(order);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void setOrder(long id) {
		
	}

	
}