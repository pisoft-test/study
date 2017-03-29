package io.pisoft.study.struts;

import mo.com.pisoft.sat.core.StartupConfiguration;
import mo.com.pisoft.sat.runtime.jetty7.Jetty7ServerLauncher;

public class ManualTest {
	public static void main(String[] args) throws Exception {
		Jetty7ServerLauncher launcher = new Jetty7ServerLauncher();
		StartupConfiguration cfg = new StartupConfiguration();
		cfg.setOverrideWebXml("web-manual-test.xml");
		launcher.startServer(cfg);
	}
}
