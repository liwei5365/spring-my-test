package com.asb.ponnbi.mbean.singleton;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import com.asb.ponnbi.mbean.normal.AbstractAppStartup;
import com.asb.ponnbi.mbean.util.JBossUtil;

public abstract class AbstractSingletonAppStartup extends AbstractAppStartup implements SingletonAppStartupMBean {

	private ClassLoader contextClassLoader;
	
	private SingletonDeployerMBean getService() {
		try {
			return JBossUtil.lookupMBean(new ObjectName(SingletonDeployerMBean.NAME), SingletonDeployerMBean.class);
		} catch (MalformedObjectNameException e) {
			throw new RuntimeException(e);
		}
	}

	protected void startService() throws Exception {
		contextClassLoader =  Thread.currentThread().getContextClassLoader();
		getService().addDeployment(this);
	}
	
	protected final ClassLoader getContextClassLoader() {
		return contextClassLoader;
	}
	protected void stopService() {
		stopSingleton();
	}
}