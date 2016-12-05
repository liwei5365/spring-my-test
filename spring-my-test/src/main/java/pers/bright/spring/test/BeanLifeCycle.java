package pers.bright.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.bright.spring.Person;
import pers.bright.spring.annotation.MyAnnotationBean;


public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("���ڿ�ʼ��ʼ������");
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("beantest.xml");
        System.out.println("������ʼ���ɹ�");    
        //�õ�Preson����ʹ��
        Person person = factory.getBean("person1",Person.class);
        System.out.println(person);
        //
        MyAnnotationBean annotion = factory.getBean("mytest",MyAnnotationBean.class);
        System.out.println(annotion);
        System.out.println("���ڿ�ʼ�ر�������");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}