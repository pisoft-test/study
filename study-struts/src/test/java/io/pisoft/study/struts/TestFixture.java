package io.pisoft.study.struts;

import mo.com.pisoft.sat.runtime.WebAppTestContext;
import mo.com.pisoft.sat.runtime.WebTestConfiguration;
import mo.com.pisoft.sat.runtime.jetty7.Jetty7ServerLauncher;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestFixture {

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		WebTestConfiguration cfg = new WebTestConfiguration();
		cfg.setWebServerLauncherClass(Jetty7ServerLauncher.class);
		cfg.setSeleniumDriverClass(FirefoxDriver.class);
		WebAppTestContext.beforeTests(cfg);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebAppTestContext.afterTests();
	}
}
