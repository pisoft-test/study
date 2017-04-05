package io.pisoft.study.struts.action;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.service.OrderService;
import mo.com.pisoft.sat.core.ChangeResistantMockFactory;

public class SubmitOrderActionTest2 {
	public static void main(String[] args) {
		new SubmitOrderActionTest2().test();
	}

	private void test() {
		ChangeResistantMockFactory factory = new ChangeResistantMockFactory(this);
		OrderService orderService = factory.implementAbstractMethods(MockedOrderService.class);
		
	}

	abstract class MockedOrderService implements OrderService {
		@Override
		public void createOrder(Order order) {

		}
	}
}
