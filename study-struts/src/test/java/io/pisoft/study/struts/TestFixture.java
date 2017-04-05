package io.pisoft.study.struts;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.pisoft.study.test.jetty.test.WebAppTestConfiguration;
import io.pisoft.study.test.jetty.test.WebAppTestContext;

public class TestFixture {

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		WebAppTestConfiguration cfg = new WebAppTestConfiguration();
		cfg.setOverrideWebXml("web-test.xml");
		cfg.setSeleniumDriverClass(FirefoxDriver.class);
		WebAppTestContext.beforeTests(cfg);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebAppTestContext.afterTests();
	}
}
