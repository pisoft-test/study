package io.pisoft.study.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.pisoft.study.core.jpa.Persistable;

@Entity
public class Address implements Persistable {

	@Id
	@GeneratedValue
	private Long id;

	private String province;
	private String city;
	private String area;
	private String details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city="
				+ city + ", area=" + area + ", details=" + details + "]";
	}

}
