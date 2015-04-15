package pers.bright.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import pers.bright.spring.annotation.AnnotationMBean;
import pers.bright.spring.annotation.MyAnnotationBean;

@Configuration
@ImportResource("classpath:mbbeantest.xml")
public class MbeanTest {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext acaContext = new AnnotationConfigApplicationContext();
		acaContext.register(MbeanTest.class);
		acaContext.refresh();
		test(acaContext);
		acaContext.registerShutdownHook();
	}

	private static void test(AnnotationConfigApplicationContext acaContext) throws Exception {
		// TODO Auto-generated method stub
		MyAnnotationBean MyAnnotation = acaContext.getBean(MyAnnotationBean.class);
		System.out.println("MyAnnotation = " + MyAnnotation);
		AnnotationMBean mbean = acaContext.getBean(AnnotationMBean.class);
		System.out.println("mbean = " + mbean);
		Object lock = new Object();  
	        synchronized (lock) {  
	            lock.wait();  
	    }
	}
}
