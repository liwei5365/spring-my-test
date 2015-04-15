package com.asb.ponnbi.mbean.example;

import org.jboss.as.server.ServerEnvironment;
import org.jboss.logging.Logger;
import org.jboss.msc.inject.Injector;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.jboss.msc.value.InjectedValue;

public class SingletonExampleService implements Service<String> {

	private static final Logger logger = Logger.getLogger(SingletonExampleService.class.getName());
	
	public static final ServiceName SERVICE_NAME = ServiceName.JBOSS.append("singletonService", "example");
	
	private final InjectedValue<ServerEnvironment> env = new InjectedValue<ServerEnvironment>();

	public Injector<ServerEnvironment> getEnvInjector() {
		return this.env;
	}

	@Override
	public String getValue() throws IllegalStateException, IllegalArgumentException {

		return this.toString();

	}

	@Override
	public void start(StartContext ctx) throws StartException {

		logger.info("SingletonExampleService Starting singleton service...");
		logger.info("SingletonExampleService Start singleton done");

	}

	@Override
	public void stop(StopContext ctx) {

		logger.info("SingletonExampleService Stopping singleton service...");

		logger.info("SingletonExampleService Stop singleton done");

	}

}