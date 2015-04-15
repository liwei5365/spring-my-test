package pers.bright.spring.annotation;

import java.lang.annotation.Annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@MyAnnotation("mytest")
public class MyAnnotationBean {
	
	@Value("myannotationtest")
	private String name;
	private String address;
	@Value("111111")
	private int phone;
	public static String static_value="static_value_test";
	//
    public MyAnnotationBean() {
        System.out.println("【构造器】调用MyAnnotationBean的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name = "+name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MyAnnotationBean [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    } 

    // 通过<bean>的init-method属性指定的初始化方法
    @PostConstruct
    public void myInit() {
        System.out.println("【init-method】调用<bean>的 @PostConstruct属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    @PreDestroy
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的@PreDestroy属性指定的初始化方法");
    }
    }
