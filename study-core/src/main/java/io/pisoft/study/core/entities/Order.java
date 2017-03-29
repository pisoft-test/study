package io.pisoft.study.core.entities;

import io.pisoft.study.core.jpa.Persistable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Persistable {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private Person sender;
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private Person receiver;

	private Date createTime;
	private String number;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getSender() {
		return sender;
	}

	public void setSender(Person sender) {
		this.sender = sender;
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setReceiver(Person receiver) {
		this.receiver = receiver;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", sender=" + sender + ", receiver="
				+ receiver + ", createTime=" + createTime + ", number="
				+ number + ", status=" + status + "]";
	}

}
