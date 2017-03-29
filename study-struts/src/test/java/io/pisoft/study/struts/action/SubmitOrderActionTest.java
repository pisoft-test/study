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
import org.testng.annotations.Test;

public class SubmitOrderActionTest extends BasePageTest {

	private ChangeResistantMockFactory factory = new ChangeResistantMockFactory(
			this);

	abstract class MockOrderService implements OrderService {
		@Override
		public void createOrder(Order order) {
			System.out.println(order);
		}
	}

	@Test
	public void testSubmit() throws InterruptedException {

		// MockOrderService orderService = factory
		// .implementAbstractMethods(MockOrderService.class);
		// MockableBeanInjector.mockBean("orderService", orderService);

		WebDriver webDriver = WebAppTestContext.getWebDriver();
		WebDriverWrapper wrapper = new WebDriverWrapper(webDriver);
		wrapper.action("toSubmitOrderPage");
		webDriver.findElement(By.name("receiver.name")).sendKeys("abcd");
		webDriver.findElement(By.id("submit")).click();
		sleep(5);

	}

}
