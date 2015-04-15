package com.asb.ponnbi.mbean.normal;


public abstract class AbstractAppStartup {

    private String m_serviceName;

    public AbstractAppStartup() {
    }
    
    public void setServiceName(String name) {
        m_serviceName = name;
    }
    
    public String getServiceName() {
        return m_serviceName;
    }
    
    public void start() throws Exception {
        try {
            startService();
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected abstract void startService() throws Exception;

    public void stop() {
        stopService();
    }

    protected abstract void stopService();

}
