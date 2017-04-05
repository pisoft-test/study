package io.pisoft.study.test.jetty.test;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import io.pisoft.study.test.jetty.WebAppLanucher;

public class WebAppTestContext {
	private static WebAppLanucher lanucher;
	private static WebDriver driver;
	private static WebAppTestConfiguration configuration;

	public static void beforeTests() {
		beforeTests(new WebAppTestConfiguration());
	}

	public static void beforeTests(WebAppTestConfiguration cfg) {
		configuration = cfg;
		startWebServer();
		createWebDriver();
	}

	private static void createWebDriver() {
		try {
			driver = configuration.getSeleniumDriverClass().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void startWebServer() {
		try {
			lanucher = configuration.getLanucherClass().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		lanucher.startServer(configuration);
	}

	public static void afterTests() {
		lanucher.stopServer();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			try {
				driver.switchTo().window(handle).close();
			} catch (Throwable e) {
			}
		}
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static WebAppTestConfiguration getConfiguration() {
		return configuration;
	}
}
