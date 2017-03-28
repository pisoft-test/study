package io.pisoft.study.core.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.pisoft.study.core.entities.Order;

@Service
@Transactional
public class DefaultOrderService implements OrderService {

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
