package pers.bright.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource (description= "My Managed Bean" )  //objectName= "pers.bright.spring:name=mbeanTest" ,
@Component
public   class  AnnotationMBean{ 
	@Value("wli049")
    private String name; 
	@Value("33")
    private int age;  
      
    @ManagedAttribute(description="The Name Attribute")  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    @ManagedAttribute()  
    public String getName() {  
        return name;  
    }    
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    @ManagedOperation(description="Add two numbers")  
    @ManagedOperationParameters({  
    @ManagedOperationParameter(name = "x", description = "The first number"),  
    @ManagedOperationParameter(name = "y", description = "The second number")})  
    public int add_1(int x, int y) {  
        return x + y;  
    }  
  
    @ManagedOperation  
    public int add_2(int x, int y){  
        return x + y;  
    }  
    
    public void dontExposeMe() {  
        throw new RuntimeException();  
    }  
}  
