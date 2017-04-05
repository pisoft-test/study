package io.pisoft.study.struts.action;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.service.OrderService;
import io.pisoft.study.struts.BasePageTest;
import io.pisoft.study.test.jetty.test.WebAppTestContext;
import io.pisoft.study.test.selenium.ActionWrapper;
import io.pisoft.study.test.spring.ChangeResistantMockFactory;
import io.pisoft.study.test.spring.MockableBeanInjector;

public class SubmitOrderActionTest extends BasePageTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubmitOrderActionTest.class);

	private ChangeResistantMockFactory factory = new ChangeResistantMockFactory(this);
	private Order order;

	abstract class MockedOrderService implements OrderService {
		@Override
		public void createOrder(Order order) {
			LOGGER.info("run mock order service");
			SubmitOrderActionTest.this.order = order;
		}
	}

	@Test
	public void testSubmit() {
		OrderService orderService = factory.implementAbstractMethods(MockedOrderService.class);
		// MockedOrderService orderService = new MockedOrderService();
		MockableBeanInjector.mockBean("orderService", orderService);
		final WebDriver webDriver = WebAppTestContext.getWebDriver();
		ActionWrapper wrapper = new ActionWrapper(webDriver);
		wrapper.wait(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				return webDriver.findElement(By.tagName("body")).isDisplayed();
			}

		});
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
