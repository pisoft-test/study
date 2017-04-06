package io.pisoft.study.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.ttdev.wicketpagetest.MockableSpringBeanInjector;

import io.pisoft.study.wicket.page.HomePage;

public class MyApp extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		MockableSpringBeanInjector.installInjector(this);
	}
}
