package io.pisoft.study.struts.action;

import io.pisoft.study.core.entities.Order;
import io.pisoft.study.core.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Controller("submitOrderAction")
public class SubmitOrderAction implements ModelDriven<Order>, Preparable {

	@Autowired
	OrderService orderService;

	private Order order;

	public String execute() {
		return "success";
	}

	public String submit() {
		orderService.createOrder(order);
		return "success";
	}

	@Override
	public Order getModel() {
		return order;
	}

	@Override
	public void prepare() throws Exception {
		order = new Order();
	}

}
