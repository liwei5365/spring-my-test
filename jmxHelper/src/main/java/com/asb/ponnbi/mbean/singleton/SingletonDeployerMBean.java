package com.asb.ponnbi.mbean.singleton;

public interface SingletonDeployerMBean {

	String NAME = "application.ponnbi:service=singletonDeployer";

	void addDeployment(SingletonAppStartupMBean deployment);

	boolean isMasterNode();
	
	public boolean isDeploymentCompleted();
	
}