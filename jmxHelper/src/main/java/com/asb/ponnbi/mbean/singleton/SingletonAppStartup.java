package com.asb.ponnbi.mbean.singleton;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SingletonAppStartup extends AbstractSingletonAppStartup {

    private final static Logger m_logger = Logger.getLogger(SingletonAppStartup.class);

    private static final String DEFAULT_SINGLETON_DESCRIPTOR = "applicationContext-singleton.xml";

    private GenericApplicationContext m_context;
    
    private ClassPathResource m_resource;

    @Override
    public void startSingleton() {
        synchronized (this) {
            ClassLoader old = Thread.currentThread().getContextClassLoader();
            try {
                Thread.currentThread().setContextClassLoader(getContextClassLoader());
                long start = System.currentTimeMillis();
                m_context = new GenericApplicationContext();
                
                String url = m_context.getClassLoader().getResource(DEFAULT_SINGLETON_DESCRIPTOR).getFile();
                m_logger.info("Starting Singleton Application Service " + getServiceName() +" url:"+url);
                XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(m_context);
                m_resource = new ClassPathResource(DEFAULT_SINGLETON_DESCRIPTOR);
                xmlReader.loadBeanDefinitions(m_resource);
                m_context.refresh();
                m_logger.info("Starting SingletonAppStartup:  " + getServiceName() + " took " + (System.currentTimeMillis() - start));
            } catch (Exception ex) {
                throw ex;
            } finally {
                Thread.currentThread().setContextClassLoader(old);
            }
        }
    }

    @Override
    public void stopSingleton() {
        m_logger.info("Stopping SingletonAppStartup : " + getServiceName());
//        synchronized (this) {
//            m_context.close();
//        }
    }
}