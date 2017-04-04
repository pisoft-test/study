package io.pisoft.study.test.selenium;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ActionWrapper {

	private WebDriver driver;

	public ActionWrapper(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void action(String url) {
		action(url, null);
	}

	public void action(String url, Map<String, Object> args) {
		driver.get(url);
	}

}
