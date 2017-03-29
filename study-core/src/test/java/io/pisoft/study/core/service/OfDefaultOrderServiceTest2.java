package io.pisoft.study.core.service;

import io.pisoft.study.core.entities.Address;
import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.entities.Person;
import io.pisoft.study.core.entities.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class OfDefaultOrderServiceTest2 extends CoreTest {

	@Autowired
	private OrderService orderService;

	@Test(expectedExceptions = RuntimeException.class)
	public void testCreateOrder() {
		Order order = new Order();
		Person sender;
		String province = "a";
		String area = "b";
		String city = "c";
		String details = "d";

		sender = createPerson(createAddress(province, area, city, details),
				"陈大文", "11234567890");
		order.setSender(sender);
		orderService.createOrder(order);
		assert order.getCreateTime() != null;
		assert order.getId() != null;
		assert order.getNumber() != null;
		assert order.getStatus().equals(Status.SUBMIT);
	}

	private Address createAddress(String province, String area, String city,
			String details) {
		Address address;
		address = new Address();
		address.setProvince(province);
		address.setArea(area);
		address.setCity(city);
		address.setDetails(details);
		return address;
	}

	private Person createPerson(Address address, String name, String phone) {
		Person person;
		person = new Person();
		person.setAddress(address);
		person.setName(name);
		person.setPhone(phone);
		return person;
	}
}
