package com.asb.ponnbi.mbean.normal;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppStartup extends AbstractAppStartup implements AppStartupMBean {
	private static final String DEFAULT_NAME = "applicationContext.xml";

	private static final Logger logger = Logger.getLogger(AppStartup.class);

	private ConfigurableApplicationContext ctx;

	private String m_descriptorName = DEFAULT_NAME;

	private Class<?> m_classToLoad = null;

	@Override
	protected void startService() throws Exception {
		long start = System.currentTimeMillis();
		logger.info("Starting Application Service " + getServiceName());
		ClassLoader classload = Thread.currentThread().getContextClassLoader();
		logger.info("classload = "+classload);
		if (m_classToLoad == null) {
			ctx = new ClassPathXmlApplicationContext(m_descriptorName);
		} else {
			ctx = new ClassPathXmlApplicationContext(m_descriptorName, m_classToLoad);
		}
		ctx.getClassLoader();
		logger.info("Starting Application Service " + getServiceName() + " took " + (System.currentTimeMillis() - start));
	}

	@Override
	protected void stopService() {
		logger.info("Stopping Application Service: " + getServiceName());
		if (ctx != null) {
			ctx.close();
			ctx = null;
		}
	}

	public String getSpringDescriptorName() {
		return m_descriptorName;
	}

	public void setSpringDescriptorName(String name) {
		m_descriptorName = name;

	}

	public Class<?> getClassToLoad() {
		return m_classToLoad;
	}

	public void setClassToLoad(Class classToLoad) {
		m_classToLoad = classToLoad;
	}

}
