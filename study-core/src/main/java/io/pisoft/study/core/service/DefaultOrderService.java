package io.pisoft.study.core.service;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.entities.Person;
import io.pisoft.study.core.entities.Status;
import io.pisoft.study.core.jpa.Dao;

import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {
	@Autowired
	private Dao dao;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefaultOrderService.class);

	@Override
	public void createOrder(Order order) {
		if (order.getReceiver() == null || order.getSender() == null) {
			throw new RuntimeException();
		}
		savePerson(order.getReceiver());
		savePerson(order.getSender());
		order.setCreateTime(new Date());
		String number = UUID.randomUUID().toString();
		order.setStatus(Status.SUBMIT);
		order.setNumber(number);
		dao.save(order);
	}

	private void savePerson(Person person) {
		dao.save(person.getAddress());
		dao.save(person);
	}

	@Override
	public void sendOrder(Order order) {
		
	}

}
