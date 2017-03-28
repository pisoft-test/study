package io.pisoft.study.struts.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("homeAction")
public class Action extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println();
		return super.execute();
	}

}
