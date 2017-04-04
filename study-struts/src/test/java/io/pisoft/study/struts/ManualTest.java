package io.pisoft.study.struts;

import io.pisoft.study.test.jetty.WebAppConfiguration;
import io.pisoft.study.test.jetty.WebAppJettyLanucher;
import io.pisoft.study.test.jetty.WebAppLanucher;

public class ManualTest {
	public static void main(String[] args) {
		WebAppLanucher lanucher = new WebAppJettyLanucher();
		WebAppConfiguration cfg = new WebAppConfiguration();
		lanucher.startServer(cfg);
	}
}
