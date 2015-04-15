package pers.bright.spring.annotation.aop.old;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("aop.test1.aferThrowing")
public class AferThrowingThrowsAdvice implements ThrowsAdvice{
	
	@Override
	public String toString() {
		return "AferThrowingThrowsAdvice [method=" + method + ", args="
				+ Arrays.toString(args) + ", target=" + target + ", ex=" + ex
				+ "]";
	}
	private Method method;
	private Object[] args;
	private Object target;
	private Exception ex;
	

//	public void afterThrowing(RemoteException ex){}
	@Order(2)
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		this.method=method;
		this.args=args;
		this.target=target;
		this.ex=ex;
		System.out.println(this.toString());
	}
	@Order(0)
	public void afterThrowing(Exception ex){
		System.out.println("AferThrowingThrowsAdvice Exception = "+ex.getMessage());
	}
//	public void afterThrowing(Method method, Object[] args, Object target, ServletException ex)
}
