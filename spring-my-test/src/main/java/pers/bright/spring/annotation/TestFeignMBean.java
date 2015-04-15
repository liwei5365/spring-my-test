package pers.bright.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class TestFeignMBean{ 
	@Value("wli049")
    private String name; 
	@Value("33")
    private int age;  
      
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getName() {  
        return name;  
    }    
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    public int add_1(int x, int y) {
 
        return x + y;  
    }  
  
    public int add_2(int x, int y){  
        return x + y;  
    }  
    
    public void dontExposeMe() {  
        throw new RuntimeException();  
    }  
}  
