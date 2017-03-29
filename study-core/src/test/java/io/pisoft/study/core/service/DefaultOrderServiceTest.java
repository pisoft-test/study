package io.pisoft.study.core.service;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.entities.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class DefaultOrderServiceTest extends CoreTest {

	@Autowired
	private OrderService orderService;

	@Test
	public void testCreateOrder() {
		Order order = new Order();
		orderService.createOrder(order);
		assert order.getCreateTime() != null;
		assert order.getId() != null;
		assert order.getNumber() != null;
		assert order.getStatus().equals(Status.SUBMIT);
	}
}
