package io.pisoft.study.core.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.pisoft.study.core.jpa.Persistable;

@Entity
public class OrderItem implements Persistable {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name = "despatcher_id")
	private Despatcher despatcher;
	private Date createTime;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	private String status;
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Despatcher getDespatcher() {
		return despatcher;
	}

	public void setDespatcher(Despatcher despatcher) {
		this.despatcher = despatcher;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
