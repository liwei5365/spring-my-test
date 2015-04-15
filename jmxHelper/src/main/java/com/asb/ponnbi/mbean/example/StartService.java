package com.asb.ponnbi.mbean.example;

import org.jboss.as.clustering.msc.ServiceContainerHelper;
import org.jboss.as.clustering.singleton.SingletonService;
import org.jboss.as.server.CurrentServiceContainer;
import org.jboss.as.server.ServerEnvironment;
import org.jboss.as.server.ServerEnvironmentService;
import org.jboss.logging.Logger;
import org.jboss.msc.service.ServiceController;

public class StartService implements StartServiceMBean {

	private static final Logger logger = Logger.getLogger(StartService.class.getName());
	private SingletonExampleService exampleService = new SingletonExampleService();
	private ServiceController<String> controller;

	@Override
	public void start() throws Exception {
		SingletonService<String> singleton = new SingletonService<String>(exampleService, SingletonExampleService.SERVICE_NAME);
		controller = singleton.build(CurrentServiceContainer.getServiceContainer())
				.addDependency(ServerEnvironmentService.SERVICE_NAME, ServerEnvironment.class, exampleService.getEnvInjector()).install();
		controller.setMode(ServiceController.Mode.ACTIVE);
		ServiceContainerHelper.start(controller);
	}

	@Override
	public void stop() {

		//logger.info("Stopping service...");
		exampleService.stop(null);
		controller.setMode(ServiceController.Mode.REMOVE);
		//logger.info("Stop done");

	}
}