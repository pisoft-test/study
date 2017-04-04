package io.pisoft.study.test.jetty;

import java.util.Arrays;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebAppJettyLanucher implements WebAppLanucher {

	private Server server;

	@Override
	public void startServer(WebAppConfiguration cfg) {
		server = new Server(cfg.getServerPort());
		WebAppContext context = new WebAppContext();
		context.setResourceBase(cfg.getDocBase());
		context.setContextPath(cfg.getContextPath());
		context.setOverrideDescriptors(Arrays.asList(cfg.getOverrideWebXml()));
		server.setHandler(context);
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stopServer() {
		try {
			server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
