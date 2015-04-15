package pers.bright.spring.annotation.aop.old;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component("aop.test1.aferreturning")
public class AferReturningAfterReturningAdvice implements AfterReturningAdvice {
	@Override
	public String toString() {
		return "AferReturningAfterReturningAdvice [returnValue=" + returnValue
				+ ", method=" + method + ", args=" + Arrays.toString(args)
				+ ", target=" + target + "]";
	}

	private Object returnValue;
	private Method method;
	private Object[] args;
	private Object target;
	
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		this.returnValue=returnValue;
		this.method=method;
		this.args=args;
		this.target=target;
		System.out.println(this.toString());
	}

}
