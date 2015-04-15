package pers.bright.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pers.bright.spring.Person;
import pers.bright.spring.annotation.MyAnnotationBean;


public class PropertiesTest {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("beantest.xml");
        System.out.println("容器初始化成功");    
        //得到Preson，并使用
        Person person = factory.getBean("person1",Person.class);
        System.out.println(person);
        Person person2 = factory.getBean("person2",Person.class);
        System.out.println(person2);
        //
        MyAnnotationBean annotion = factory.getBean("mytest",MyAnnotationBean.class);
        System.out.println(annotion);
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}