package io.pisoft.study.core.service;

import io.pisoft.study.core.entities.Order;

public interface OrderService {
	public void createOrder(Order order);

	public void sendOrder(Order order);
}
