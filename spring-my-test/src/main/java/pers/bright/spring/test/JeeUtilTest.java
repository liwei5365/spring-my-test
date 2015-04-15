package pers.bright.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:jeeUtiltest.xml")
public class JeeUtilTest {

	public static void main(String[] args) throws Exception {
		registerSpring(JeeUtilTest.class);
	}
	private static void test(AnnotationConfigApplicationContext acaContext)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}
	private static void registerSpring(Class configuration) throws Exception {
		AnnotationConfigApplicationContext acaContext = new AnnotationConfigApplicationContext();
		acaContext.register(configuration);
		acaContext.refresh();
		String[] bNames = acaContext.getBeanDefinitionNames();	
		for (String name : bNames) {
			if(name.contains("springframework")){
				//ignore now
			}else{
				System.out.println("name = " + name);
				System.out.println("value = "+String.valueOf(acaContext.getBean(name)));
			}
			
		}
		test(acaContext);
		acaContext.registerShutdownHook();
	}


}
