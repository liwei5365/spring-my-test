package com.asb.ponnbi.mbean.normal;

public interface AppStartupMBean {

	void setSpringDescriptorName(String name);

	String getSpringDescriptorName();

	Class getClassToLoad();

	void setClassToLoad(Class classToLoad);
	
	void start() throws Exception;
	
	void stop() throws Exception;
}
