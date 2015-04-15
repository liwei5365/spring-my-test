package pers.bright.spring.test;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pers.bright.spring.annotation.aop.IReviewSkills;
import pers.bright.spring.annotation.aop.IVisionGril;
import pers.bright.spring.annotation.aop.old.MyIntroductionInterceptor;

@Configuration
@ComponentScan("pers.bright.spring.annotation.aop")
public class AopTest1 {

	@Bean(name = { "aoptest.proxy" })
	public ProxyFactoryBean getIReviewSkills() throws ClassNotFoundException {
		ProxyFactoryBean proxy = new ProxyFactoryBean();
//		proxy.setInterfaces(new Class[] { IReviewSkills.class,IVisionGril.class });
		proxy.setProxyInterfaces(new Class[] { IReviewSkills.class,IVisionGril.class});
		proxy.setTargetName("aoptest.impl");
		proxy.setInterceptorNames(new String[] { "aop.test1.before",
				"aop.test1.aferreturning", "aop.test1.around",
				"aop.test1.aferThrowing","aop.test1.myintroduction" });
//		proxy.setProxyTargetClass(true);
		return proxy;
	}
	
//	@Bean(name={"aoptest.myintroduction"})
//	public Advice getIntroductionAdvisior(){
//		return new MyIntroductionInterceptor();
//	}
//	@Bean(name={"aoptest.introduction"})
//	public DefaultIntroductionAdvisor getDefaultIntroductionAdvisor(){
//		DefaultIntroductionAdvisor introduction = new DefaultIntroductionAdvisor(getIntroductionAdvisior());
//		return introduction;
//		
//	}
	public static void main(String[] args) throws Exception {
		registerSpring(AopTest1.class, "aoptest");
	}

	private static void test(AnnotationConfigApplicationContext acaContext)
			throws Exception {
		// TODO Auto-generated method stub

		IReviewSkills ir1 = (IReviewSkills) acaContext.getBean("aoptest.proxy");
		try {
			ir1.dizzying();
		} catch (Exception e) {
			System.out.println("IReviewSkills catch Exception, e = "
					+ e.getMessage());
		}
//		IVisionGril vg=(IVisionGril)ir1;
		((IVisionGril)ir1).lookMore("beautiful gril");
		//
	}

	private static void registerSpring(Class configuration, String pattern)
			throws Exception {
		AnnotationConfigApplicationContext acaContext = new AnnotationConfigApplicationContext();
		acaContext.register(configuration);
		acaContext.refresh();
		String[] bNames = acaContext.getBeanDefinitionNames();
		for (String name : bNames) {
			if (name.contains(pattern)) {
				System.out.println("name = " + name);
				System.out.println("value = "
						+ String.valueOf(acaContext.getBean(name)));
			}
		}
		test(acaContext);
		acaContext.registerShutdownHook();
	}
}
