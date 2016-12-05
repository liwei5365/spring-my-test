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
        System.out.println("��������������MyAnnotationBean�Ĺ�����ʵ����");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("��ע�����ԡ�ע������name = "+name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("��ע�����ԡ�ע������address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("��ע�����ԡ�ע������phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MyAnnotationBean [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    } 

    // ͨ��<bean>��init-method����ָ���ĳ�ʼ������
    @PostConstruct
    public void myInit() {
        System.out.println("��init-method������<bean>�� @PostConstruct����ָ���ĳ�ʼ������");
    }

    // ͨ��<bean>��destroy-method����ָ���ĳ�ʼ������
    @PreDestroy
    public void myDestory() {
        System.out.println("��destroy-method������<bean>��@PreDestroy����ָ���ĳ�ʼ������");
    }
    }
