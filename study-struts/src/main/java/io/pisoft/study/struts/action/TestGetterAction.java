package io.pisoft.study.struts.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import io.pisoft.study.core.entities.Address;

@Controller("testGetterAction")
public class TestGetterAction extends BaseAction {

	public String execute() {
		return "success";
	}

	public List<Address> getCurrentActionParam() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(createAddress("广东省", "珠海市", "香洲区", "中建大厦"));
		return addresses;
	}
	
	private Address createAddress(String province, String area, String city,
			String details) {
		Address address;
		address = new Address();
		address.setProvince(province);
		address.setArea(area);
		address.setCity(city);
		address.setDetails(details);
		return address;
	}


}
