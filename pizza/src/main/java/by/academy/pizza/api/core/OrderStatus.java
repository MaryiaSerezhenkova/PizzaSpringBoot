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
import javax.persistence.OneToOne;

import by.academy.pizza.api.IOrderStatus;

@Entity
public class OrderStatus implements IOrderStatus, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;
	@Column(name = "dt_update")
	private LocalDateTime dtUpdate;
	@OneToOne
    @JoinColumn(name = "ticket", referencedColumnName = "id")
	private Ticket ticket;
	@OneToMany
	@JoinColumn(name = "stage")
	private List<Stage> stages;
	@Column
	private boolean isDone;

	public OrderStatus() {
		super();
	}

	public OrderStatus(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, Ticket ticket, List<Stage> stages,
			boolean isDone) {
		super();
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.ticket = ticket;
		this.stages = stages;
		this.isDone = isDone;
	}
	public OrderStatus(Ticket ticket, List<Stage> stages,
			boolean isDone) {
		super();
		this.ticket = ticket;
		this.stages = stages;
		this.isDone = isDone;
	}

	@Override
	public Ticket getTicket() {
		return ticket;
	}

	@Override
	public List<Stage> getHistory() {
		return stages;
	}

	@Override
	public boolean isDone() {
		return isDone;
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

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
