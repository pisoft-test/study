package io.pisoft.study.core.service;

import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.entities.Status;

@Service
@Transactional
public class DefaultOrderService implements OrderService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefaultOrderService.class);

	@Override
	public void createOrder(Order order) {
		order.setCreateTime(new Date());
		UUID number = UUID.randomUUID();
		LOGGER.info("uuid is : {}", number);
		// order.setNumber(number);
	}

}
