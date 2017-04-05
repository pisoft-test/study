package io.pisoft.study.test.selenium;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.pisoft.study.test.jetty.test.WebAppTestConfiguration;
import io.pisoft.study.test.jetty.test.WebAppTestContext;

public class ActionWrapper {

	private WebDriver driver;

	public ActionWrapper(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void action(String action) {
		action(action, null);
	}

	public void action(String action, Map<String, Object> args) {
		WebAppTestConfiguration cfg = WebAppTestContext.getConfiguration();
		String targetUrl = String.format("http://localhost:%d/%s.action", cfg.getServerPort(), action);
		driver.get(targetUrl);
	}

}
