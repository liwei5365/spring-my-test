package pers.bright.spring.annotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FacotryBeanTest implements FactoryBean<Object>{

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return "FacotryBeanTest";
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
