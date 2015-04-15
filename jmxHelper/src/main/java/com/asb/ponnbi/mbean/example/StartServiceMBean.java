package com.asb.ponnbi.mbean.example;

public interface StartServiceMBean {

	/**
	 * stop the service.
	 */
	void stop();
	/**
	 * start the service. @throws Exception error
	 */
	void start() throws Exception;

}