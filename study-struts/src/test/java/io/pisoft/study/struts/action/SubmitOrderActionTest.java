package io.pisoft.study.struts.action;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.service.OrderService;
import io.pisoft.study.struts.BasePageTest;
import mo.com.pisoft.sat.core.ChangeResistantMockFactory;
import mo.com.pisoft.sat.core.MockableBeanInjector;
import mo.com.pisoft.sat.runtime.WebAppTestContext;
import mo.com.pisoft.sat.runtime.WebDriverWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SubmitOrderActionTest extends BasePageTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SubmitOrderActionTest.class);

	private ChangeResistantMockFactory factory = new ChangeResistantMockFactory(
			this);
	private Order order;

	class MockedOrderService implements OrderService {
		@Override
		public void createOrder(Order order) {
			LOGGER.info("run mock order service");
			SubmitOrderActionTest.this.order = order;
		}

		@Override
		public void sendOrder(Order order) {
			// TODO Auto-generated method stub

		}
	}

	@Test
	public void testSubmit() throws InterruptedException {
		// OrderService orderService = factory
		// .implementAbstractMethods(MockedOrderService.class);
		MockedOrderService orderService = new MockedOrderService();
		MockableBeanInjector.mockBean("orderService", orderService);
		WebDriver webDriver = WebAppTestContext.getWebDriver();
		WebDriverWrapper wrapper = new WebDriverWrapper(webDriver);
		wrapper.action("toSubmitOrderPage");
		webDriver.findElement(By.name("sender.name")).sendKeys("陈大文");
		webDriver.findElement(By.name("sender.phone")).sendKeys("13800002255");
		webDriver.findElement(By.name("receiver.phone")).sendKeys("13544662288");
		webDriver.findElement(By.id("submit")).click();
		assert order.getSender().getName().equals("陈大文");
		assert order.getSender().getPhone().equals("13800002255");
		assert order.getReceiver().getPhone().equals("13544662288");
	}

}
