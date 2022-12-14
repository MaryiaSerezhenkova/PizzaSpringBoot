package by.academy.pizza.api.core;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import by.academy.pizza.api.IPizzaInfo;

@Entity
@Table(name = "pizza_info", schema="app")
public class PizzaInfo implements IPizzaInfo, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_info_id_gen")
	@SequenceGenerator(initialValue = 1000, name = "pizza_info_id_gen", sequenceName = "pizza_info_id_sequence", allocationSize = 1)
	private Long id;
	@Column(name = "dt_create")
	private LocalDateTime dtCreate;
	@Column(name = "dt_update")
	private LocalDateTime dtUpdate;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int size;

	public PizzaInfo(Long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, String description,
			int size) {
		super();
		this.id = id;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.name = name;
		this.description = description;
		this.size = size;
	}

	public PizzaInfo(String name, String description, int size) {
		super();
		this.name = name;
		this.description = description;
		this.size = size;
	}

	public PizzaInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaInfo [id=");
		builder.append(id);
		builder.append(", dtCreate=");
		builder.append(dtCreate);
		builder.append(", dtUpdate=");
		builder.append(dtUpdate);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
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

	public String getDescription() {
		return description;
	}

	public int getSize() {

		return size;
	}
}
