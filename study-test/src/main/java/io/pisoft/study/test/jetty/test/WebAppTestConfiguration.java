package io.pisoft.study.test.jetty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.pisoft.study.test.jetty.WebAppConfiguration;
import io.pisoft.study.test.jetty.WebAppJettyLanucher;
import io.pisoft.study.test.jetty.WebAppLanucher;

public class WebAppTestConfiguration extends WebAppConfiguration {
	private Class<? extends WebDriver> seleniumDriverClass = System.getProperty("os.name").toLowerCase()
			.contains("windows") ? InternetExplorerDriver.class : FirefoxDriver.class;

	private int maxSecondsToWaitReponse = 10;
	private Class<? extends WebAppLanucher> lanucherClass = WebAppJettyLanucher.class;

	public Class<? extends WebDriver> getSeleniumDriverClass() {
		return seleniumDriverClass;
	}

	public void setSeleniumDriverClass(Class<? extends WebDriver> seleniumDriverClass) {
		this.seleniumDriverClass = seleniumDriverClass;
	}

	public int getMaxSecondsToWaitReponse() {
		return maxSecondsToWaitReponse;
	}

	public void setMaxSecondsToWaitReponse(int maxSecondsToWaitReponse) {

	}

	public Class<? extends WebAppLanucher> getLanucherClass() {
		return lanucherClass;
	}

	public void setLanucherClass(Class<? extends WebAppLanucher> lanucherClass) {
		this.lanucherClass = lanucherClass;
	}

}
