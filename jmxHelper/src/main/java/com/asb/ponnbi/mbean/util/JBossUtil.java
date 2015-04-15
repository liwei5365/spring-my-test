package com.asb.ponnbi.mbean.util;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.apache.log4j.Logger;

import com.asb.ponnbi.mbean.singleton.SingletonDeployerMBean;

//import com.alcatel.axs.applications.common.mbean.SingletonDeployerMBean;

/**
 * Created by IntelliJ IDEA.
 * User: stappend
 * Date: Aug 4, 2006
 * Time: 3:50:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class JBossUtil {

    private static final Logger m_log = Logger.getLogger(JBossUtil.class);

    private static MBeanServer m_localMBeanServer;
    
    public static final String MASTER_NODE = "MasterNode";


    public static <T> T lookupMBean(String name, Class<T> interfaceClass) {
        ObjectName objectName = getObjectName(name);
        return lookupMBean(objectName, interfaceClass);
    }

    public static <T> T lookupMBean(ObjectName objectName, Class<T> interfaceClass) {
    	try {
            getLocalMBeanServer();
            int i=0;
            while(!m_localMBeanServer.isRegistered(objectName)&&i<3){
            	m_log.info(m_localMBeanServer. getMBeanInfo(objectName));
            	Thread.sleep(1000);
            	i++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return MBeanServerInvocationHandler.newProxyInstance(getLocalMBeanServer(), objectName, interfaceClass, false);
    }

    public static ObjectName getObjectName(String name) {
        try {
            return new ObjectName(name);
        } catch (MalformedObjectNameException e) {
            throw new RuntimeException(e);
        }
    }

    public static MBeanServer getLocalMBeanServer() {
        //checkLocation();

        if (m_localMBeanServer == null) {
            m_localMBeanServer = ManagementFactory.getPlatformMBeanServer();
        }
        return m_localMBeanServer;
    }

    public static void setLocalMBeanServer(MBeanServer mBeanServer) {
        m_localMBeanServer = mBeanServer;
    }
    
    // for test purposes
    public static void usePlatformMBeanServer() {
        m_localMBeanServer = ManagementFactory.getPlatformMBeanServer();
    }
    
    public static boolean isMasterNode() {
		try {
			return lookupMBean(SingletonDeployerMBean.NAME, SingletonDeployerMBean.class).isMasterNode();
		} catch (Exception e) {
			m_log.error("Could not retrieve the App Server type!", e);
		}
		return false;
	}

}