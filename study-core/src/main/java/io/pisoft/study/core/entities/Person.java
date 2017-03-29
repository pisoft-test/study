package io.pisoft.study.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.pisoft.study.core.jpa.Persistable;

@Entity
public class Person implements Persistable {

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + "]";
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
