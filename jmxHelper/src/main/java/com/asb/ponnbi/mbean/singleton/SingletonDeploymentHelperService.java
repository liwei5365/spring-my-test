package com.asb.ponnbi.mbean.singleton;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import org.jboss.logging.Logger;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;


public class SingletonDeploymentHelperService implements Service<String> {

    private static final Logger m_logger = Logger.getLogger(SingletonDeploymentHelperService.class.getName());
    private Deque<SingletonAppStartupMBean> deployments = new LinkedList<SingletonAppStartupMBean>();
    private boolean m_isCompleted = true;
    
    public void addDeployment(boolean isMaster, SingletonAppStartupMBean deployment) {
        if (isMaster) {
            deployment.startSingleton();
        } else {
            deployments.add(deployment);
        }
    }

    public void removeDeployment(SingletonAppStartupMBean deployment) {
        deployments.remove(deployment);
    }

    @Override
    public String getValue() throws IllegalStateException, IllegalArgumentException {
        return null;
    }

    public void start(StartContext context) throws StartException {
        m_isCompleted = false;
        m_logger.info("Starting singleton services :[ SingletonDeploymentHelperService]");
        
        Iterator<SingletonAppStartupMBean> iter = deployments.iterator();
        while(iter.hasNext()) {
            iter.next().startSingleton();
        }
        m_isCompleted = true;
    }

    public void stop(StopContext context) {
        m_logger.info("Stopping singleton services");
        Iterator<SingletonAppStartupMBean> iter = deployments.descendingIterator();
        while(iter.hasNext()) {
            iter.next().stopSingleton();
        }
    }
    
    public boolean isDeploymentCompleted() {
        return m_isCompleted;
    }
}