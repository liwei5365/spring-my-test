package pers.bright.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pers.bright.spring.annotation.MyAnnotationBean;

@Configuration
public class CustomizeScanTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(CustomizeScanTest.class);
		// annotationConfigApplicationContext.scan("pers.bright.spring");
		annotationConfigApplicationContext.refresh();
		MyAnnotationBean MyAnnotation = annotationConfigApplicationContext
				.getBean(MyAnnotationBean.class);
		System.out.println("MyAnnotation = " + MyAnnotation);
		// annotationConfigApplicationContext.getBean(CustomizeScanTest.class);
		//

		annotationConfigApplicationContext.close();
	}

	@Bean
	public MyAnnotationBean getMyAnnotation() {
		return new MyAnnotationBean();
	}

}