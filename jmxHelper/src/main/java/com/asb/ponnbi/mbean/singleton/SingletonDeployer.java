package com.asb.ponnbi.mbean.singleton;

import org.apache.log4j.Logger;
import org.jboss.as.clustering.msc.ServiceContainerHelper;
import org.jboss.as.clustering.singleton.SingletonService;
import org.jboss.as.server.CurrentServiceContainer;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceController.Mode;
import org.jboss.msc.service.ServiceName;

import com.asb.ponnbi.mbean.normal.AbstractAppStartup;

public class SingletonDeployer extends AbstractAppStartup implements SingletonDeployerMBean {
	
	private static final Logger m_logger = Logger.getLogger(SingletonDeployer.class);
	
	private SingletonDeploymentHelperService service = new SingletonDeploymentHelperService();

	public static final ServiceName SERVICE_NAME = ServiceName.JBOSS.append("ponnbi", "test", "singletonDeployer");

	private ServiceController<String> controller;
	private SingletonService<String> singleton;

	public void addDeployment(SingletonAppStartupMBean deployment) {
		service.addDeployment(singleton.isMaster(), deployment);
	}

	@Override
	protected void startService() throws Exception {
		m_logger.info("SingletonDeployer startService START");
		singleton = new SingletonService<String>(service, SERVICE_NAME);
		controller = singleton.build(CurrentServiceContainer.getServiceContainer()).install();
		controller.setMode(Mode.ACTIVE);
		ServiceContainerHelper.start(controller);
		m_logger.info("SingletonDeployer startService END ");
	}

	// public String getName() {
	// return SingletonDeployerMBean.NAME.split("[=]",2)[1];
	// }
	@Override
	public boolean isMasterNode() {
		return singleton.isMaster();
	}

	@Override
	protected void stopService() {
		service.stop(null);
		controller.setMode(Mode.REMOVE);
	}

	public boolean isDeploymentCompleted() {
		return service.isDeploymentCompleted();
	}
}