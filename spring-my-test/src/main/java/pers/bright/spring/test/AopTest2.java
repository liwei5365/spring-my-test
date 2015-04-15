package pers.bright.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pers.bright.spring.annotation.FbTest2;
import pers.bright.spring.annotation.aop.IReviewSkills;
import pers.bright.spring.annotation.aop.now.MessAspectTest;

@Configuration
@ComponentScan("pers.bright.spring.annotation.aop")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopTest2 {
	
	public static void main(String[] args) throws Exception {
		registerSpring(AopTest2.class, "aoptest");
	}

	private static void test(AnnotationConfigApplicationContext acaContext)
			throws Exception {
		// TODO Auto-generated method stub
		IReviewSkills rs2 = acaContext.getBean("aoptest.impl",IReviewSkills.class);
		MessAspectTest messClass=acaContext.getBean("messClass",MessAspectTest.class);
		rs2.recall(new FbTest2());
		messClass.recall("^V^");
		rs2.reMemory("we are young ");
		messClass.reMemory("^V^");
		try{
			rs2.dizzying();
		}catch(Exception e){
			System.out.println("IReviewSkills catch Exception, e = "
					+ e.getMessage());
		}
		try{
			messClass.dizzying();
		}catch(Exception e){
			System.out.println("IReviewSkills catch Exception, e = "
					+ e.getMessage());
		}
//		((pers.bright.spring.annotation.aop.IVisionGril)rs2).lookMore("beautiful girl");
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
