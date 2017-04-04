package io.pisoft.study.test.jetty;

public class WebAppConfiguration {

	private String docBase = "src/main/webapp";
	private int serverPort = 8888;
	private String overrideWebXml = null;
	private String contextPath = "/";

	public String getDocBase() {
		return docBase;
	}

	public void setDocBase(String docBase) {
		this.docBase = docBase;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getOverrideWebXml() {
		return overrideWebXml;
	}

	public void setOverrideWebXml(String overrideWebXml) {
		this.overrideWebXml = overrideWebXml;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}
