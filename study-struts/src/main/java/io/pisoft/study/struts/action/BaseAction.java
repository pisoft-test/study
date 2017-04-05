package io.pisoft.study.struts.action;

public class BaseAction {

	public String getParrentParam() {
		System.out.println("In parent action getter is been called");
		return "in parent param";
	}

}
