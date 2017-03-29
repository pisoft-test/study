package io.pisoft.study.struts;

public class BasePageTest {
	protected void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
