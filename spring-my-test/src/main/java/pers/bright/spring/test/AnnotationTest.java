package pers.bright.spring.test;

import java.lang.annotation.Annotation;

import org.springframework.stereotype.Component;

import pers.bright.spring.annotation.MyAnnotation;

@MyAnnotation
public class AnnotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Annotation[] ats = AnnotationTest.class.getAnnotations();
//		Component dd = AnnotationTest.class.getAnnotation(Component.class);
//		Annotation[] dd = AnnotationTest.class.getDeclaredAnnotations();
		System.out.println("===========================");
		System.out.println("ats.length = "+ats.length);
    	for(Annotation at:ats){
    		System.out.println(at);
    		
    	}
    	System.out.println("===========================");
	}

}
