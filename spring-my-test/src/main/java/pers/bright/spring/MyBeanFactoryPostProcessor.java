package pers.bright.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("����BeanFactoryPostProcessorʵ���๹��������");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        System.out
                .println("BeanFactoryPostProcessor����postProcessBeanFactory����");
        BeanDefinition bd = beanFactory.getBeanDefinition("person1");
        bd.getPropertyValues().addPropertyValue("phone", "110");
        BeanDefinition mytest = beanFactory.getBeanDefinition("mytest");
        mytest.getPropertyValues().addPropertyValue("phone", "110");
    }

}